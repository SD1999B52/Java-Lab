import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.Thread;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class snake {
	final static int SPEED = 300, OTHERSPEED = 100;
	
	//static int[][] map = new int[строки][столбцы];
	static int[][] map = new int[10][20];
	static int[][] objects = new int[3][map[0].length * map.length];
	static int side = 0, buttonnum = 0, clbuttonnum = 0;
	static int foodstr = 0, foodsto = 0;
	static int savescore = loadRecord(), score = 0;
	static JPanel panel;
	
	public static void main( String[] args ) {
		JFrame app = new JFrame();
		app.setTitle( "Snake" );
		app.setIconImage( myIcon());
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setSize( 800, 600 );
		app.setFocusable( true );
		app.requestFocus();
		
		panel = new JPanel() {
			public void paintComponent( Graphics g ) {
				super.paintComponent( g );
				int min = 0;
				int wrect = panel.getSize().width;
				int hrect = panel.getSize().height;
				g.setColor( new Color( 0, 0, 0 ));
				g.fillRect( 0, 0, wrect, hrect );
				if (( wrect / ( map[0].length + 8 )) > ( hrect / map.length )) {
					min = hrect / ( map.length );
				} else {
					min = wrect / ( map[0].length + 8 );
				}
				for ( int i = 0; i < map[0].length; i++ ) {
					for ( int i2 = 0; i2 < map.length; i2++ ) {
						g.setColor( new Color( 0, 255, 0 ));
						g.drawRect( i * min, i2 * min, min, min );
						if ( map[i2][i] == 1 ) {
							g.fillRect( i * min, i2 * min, min, min );
						}
						if ( map[i2][i] == 2 ) {
							g.fillOval( i * min, i2 * min, min, min );
						}
					}
				}
				int maplength = min * map[0].length + 5;
				g.setFont( new Font( "TimesRoman", Font.PLAIN, min ));
				g.drawString( "Keys: W,A,S,D", maplength, min * 1 );
				g.drawString( "Record: ", maplength, min * 3 );
				g.drawString( drowScore( savescore ), maplength, min * 4 );
				g.drawString( "Score: ", maplength, min * 5 );
				g.drawString( drowScore( score ), maplength, min * 6 );
			}
		};
		
		app.add( panel, BorderLayout.CENTER );
		app.addKeyListener( new KeyAdapter() {
			public void keyPressed ( KeyEvent e ) {
				if ( e.getKeyCode() == 65 ) buttonnum = 1; //кнопка A 1
				if ( e.getKeyCode() == 68 ) buttonnum = 2; //кнопка D 2
				if ( e.getKeyCode() == 87 ) buttonnum = 3; //кнопка W 3
				if ( e.getKeyCode() == 83 ) buttonnum = 4; //кнопка S 4
			}
		});
		app.setVisible( true );
		
		newGame();
		
		while ( 1 < 2 ) {
			//проверка зажатия клавиши и увеличения скорости игры
			boolean skipsetside = false;
			if (( buttonnum == 1 ) & ( side == 2 )) {
				skipsetside = true;
			}
			if (( buttonnum == 2 ) & ( side == 1 )) {
				skipsetside = true;
			}
			if (( buttonnum == 3 ) & ( side == 4 )) {
				skipsetside = true;
			}
			if (( buttonnum == 4 ) & ( side == 3 )) {
				skipsetside = true;
			}
			if (( skipsetside == false ) & ( buttonnum != 0 )) {
				side = buttonnum;
			}
			
			int sleeptime = SPEED;
			if (( clbuttonnum == buttonnum ) & ( buttonnum != 0 )) {
				sleeptime = OTHERSPEED;
			} else {
				clbuttonnum = buttonnum;
			}
			
			buttonnum = 0;
			
			//движение, коллизия, "круглый мир", рост
			if ( side == 4 ) {
				if ( objects[1][0] + 1 < map.length ) {
					if (( objects[1][0] + 1 == foodstr ) & ( objects[2][0] == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0] + 1][objects[2][0]] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[1][0] += 1;
						}
					}
				} else {
					if (( 0 == foodstr ) & ( objects[2][0] == foodsto )) {
						addLinks();
					} else {
						if ( map[0][objects[2][0]] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[1][0] = 0;
						}
					}
				}
			}
			if ( side == 3 ) {
				if ( objects[1][0] - 1 >= 0 ) {
					if (( objects[1][0] - 1 == foodstr ) & ( objects[2][0] == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0] - 1][objects[2][0]] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[1][0] -= 1;
						}
					}
				} else {
					if (( map.length - 1 == foodstr ) & ( objects[2][0] == foodsto )) {
						addLinks();
					} else {
						if ( map[map.length - 1][objects[2][0]] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[1][0] = map.length - 1;
						}
					}
				}
			}
			if ( side == 2 ) {
				if ( objects[2][0] + 1 < map[0].length ) {
					if (( objects[1][0] == foodstr ) & ( objects[2][0] + 1 == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0]][objects[2][0] + 1] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[2][0] += 1;
						}
					}
				} else {
					if (( objects[1][0] == foodstr ) & ( 0 == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0]][0] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[2][0] = 0;
						}
					}
				}
			}
			if ( side == 1 ) {
				if ( objects[2][0] - 1 >= 0 ) {
					if (( objects[1][0] == foodstr ) & ( objects[2][0] - 1 == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0]][objects[2][0] - 1] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[2][0] -= 1;
						}
					}
				} else {
					if (( objects[1][0] == foodstr ) & ( map[0].length - 1 == foodsto )) {
						addLinks();
					} else {
						if ( map[objects[1][0]][map[0].length - 1] == 1 ) {
							death();
							continue;
						} else {
							moveLinks();
							objects[2][0] = map[0].length - 1;
						}
					}
				}
			}
			
			outMap();
			
			try {
				Thread.sleep( sleeptime );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static void death() {
		if ( savescore < score ) {
			saveRecord();
			savescore = score;
		}
		newGame();
	}
	
	public static void newGame() {
		for ( int i = 0; i < objects[0].length; i++ ) {
			objects[0][i] = 0;
			objects[1][i] = 0;
			objects[2][i] = 0;
		}
		
		score = 0;
		buttonnum = 0;
		clbuttonnum = 0;
		
		genSnake();
		objToMap();
		genFood();
	}
	
	public static void genSnake() {
		//метод генерации змеи и направления ее перемещения
		int[] arrayside = new int[4];
		int strhadsnake = (int)( Math.random() * map.length );
		int stohadsnake = (int)( Math.random() * map[0].length );
		int i = 0;
		if ( strhadsnake - 3 >= 0 ) {
			arrayside[i] = 1; //up
			i += 1;
		}
		if ( strhadsnake + 3 < map.length ) {
			arrayside[i] = 2; //down
			i += 1;
		}
		if ( stohadsnake - 3 >= 0 ) {
			arrayside[i] = 3; //left
			i += 1;
		}
		if ( stohadsnake + 3 < map[0].length ) {
			arrayside[i] = 4; //right
			i += 1;
		}
		int genside = arrayside[(int)( Math.random() * i )];

		objects[0][0] = 1;
		objects[1][0] = strhadsnake;
		objects[2][0] = stohadsnake;
		
		for ( i = 1; i <= 3; i++ ) {
			objects[0][i] = 1;
			if ( genside == 1 ) {
				objects[1][i] = strhadsnake - i;
				objects[2][i] = stohadsnake;
			}
			if ( genside == 2 ) {
				objects[1][i] = strhadsnake + i;
				objects[2][i] = stohadsnake;
			}
			if ( genside == 3 ) {
				objects[1][i] = strhadsnake;
				objects[2][i] = stohadsnake - i;
			}
			if ( genside == 4 ) {
				objects[1][i] = strhadsnake;
				objects[2][i] = stohadsnake + i;
			}
		}
		
		if ( genside == 1 ) {
			side = 4;
		}
		if ( genside == 2 ) {
			side = 3;
		}
		if ( genside == 3 ) {
			side = 2;
		}
		if ( genside == 4 ) {
			side = 1;
		}
	}
	
	public static int loadRecord() {
		//метод загрузки рекорда
		int loadint = 0;
		try {
			File openfile = new File( "save.txt" );
			if ( openfile.exists() == true ) {
				FileReader savefile = new FileReader( openfile );
				Scanner in = new Scanner( savefile );
				loadint = Integer.parseInt( in.nextLine());
				savefile.close();
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return loadint;
	}
	
	public static void saveRecord() {
		//метод сохранения рекорда
		try {
			FileWriter savefile = new FileWriter( "save.txt" );
			savefile.write( Integer.toString( score ));
			savefile.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static String drowScore( int a ) {
		//метод преобразования числа в вид для отрисовки
		String text = "";
		for ( int i = 1; i < 6; i++ ) {
			if ( a < Math.pow( 10, i )) {
				text += "0";
			}
		}
		text += Integer.toString( a );
		return text;
	}
	
	public static void outMap() {
		//метод вывода карты
		objToMap();
		panel.repaint();
	}
	
	public static void addLinks() {
		//метод добавления звена
		score += 1;
		objects[0][numLinks()] = 1;
		moveLinks();
		objects[1][0] = foodstr;
		objects[2][0] = foodsto;
		objToMap();
		genFood();
	}
	
	public static void objToMap() {
		//метод перерисовки звеньев змеи и еды на карту
		for ( int i = 0; i < map.length; i++ ) {
			for ( int i2 = 0; i2 < map[0].length; i2++ ) {
				map[i][i2] = 0;
			}
		}
		for ( int i = 0; i < objects[0].length; i++ ) {
			if ( objects[0][i] != 0 ) {
				map[objects[1][i]][objects[2][i]] = 1;
			}
		}
		map[foodstr][foodsto] = 2;
	}
	
	public static void genFood() {
		//метод поиска ячеек не занятых змеей и генерации еды
		int[][] emptycel = new int[2][map[0].length * map.length];
		int i3 = 0;
		for ( int i = 0; i < map.length; i++ ) {
			for ( int i2 = 0; i2 < map[0].length; i2++ ) {
				if ( map[i][i2] == 0 ) {
					emptycel[0][i3] = i;
					emptycel[1][i3] = i2;
					i3 += 1;
				}
			}
		}
		int cellfood = (int)( Math.random() * i3 );
		foodstr = emptycel[0][cellfood];
		foodsto = emptycel[1][cellfood];
	}
	
	public static void moveLinks() {
		//метод смещения звеньев змеи
		for ( int i = numLinks(); i > 0; i-- ) {
			if ( objects[0][i] == 1 ) {
				objects[1][i] = objects[1][i - 1];
				objects[2][i] = objects[2][i - 1];
			}
		}
	}
	
	public static int numLinks() {
		//метод возвращает количество звеньев змеи
		int col = 0;
		for ( int i = 0; i < objects[0].length; i++ ) {
			if ( objects[0][i] == 1 ) {
				col += 1;
			} else {
				break;
			}
		}
		return col;
	}
	
	public static BufferedImage myIcon() {
		//метод создания иконки
		BufferedImage image = new BufferedImage( 32, 32,  BufferedImage.TYPE_INT_RGB );
		Graphics g = image.createGraphics();
		g.setColor( new Color( 0, 0, 0 ));
		g.fillRect( 0, 0, 32, 32 );
		g.setColor( new Color( 0, 255, 0 ));
		g.setFont( new Font( "TimesRoman", Font.PLAIN, 10 ));
		g.drawString( "Snake", 1, 20 );
		return image;
	}
}