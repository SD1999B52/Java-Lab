/*
под ELTEX NTP-RG-1402G-W:rev.C
отправка запросов, получение и отправка Cookie, получение HTML страницы
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.CookieManager;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class macban {
	public static void main( String[] args ) {
		try {
			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault( cookieManager );
			
			//авторизуемся и получаем Cookie
			URL address = new URL( "http://192.168.1.1/login" );
			HttpURLConnection connection = ( HttpURLConnection )address.openConnection();
			connection.setDoOutput( true );
			connection.setRequestMethod( "GET" );
			
			//отправляем логин и пароль для авторизации
			OutputStream query = connection.getOutputStream();
			String params = "username=admin&password=kW5i_1bYC6os";
			query.write( params.getBytes( "UTF-8" ));
			query.close();
			String cookie = connection.getHeaderField( "Set-Cookie" );
			
			//получаем таблицу DHCP
			address = new URL( "http://192.168.1.1/dhcpinfo.html" );
			connection = ( HttpURLConnection )address.openConnection();
			connection.setRequestProperty( "Cookie", cookie );
			String[][] DHCPArray = getTableArray( delHtml( getSheet( connection ), 0 ));
			
			//получаем таблицу ARP
			address = new URL( "http://192.168.1.1/arpview.cmd" );
			connection = ( HttpURLConnection )address.openConnection();
			connection.setRequestProperty( "Cookie", cookie );
			String[][] ARPArray = getTableArray( delHtml( getSheet( connection ), 0 ));
			
			//получаем таблицу MACFiltering
			address = new URL( "http://192.168.1.1/scoutflt.cmd?action=view" );
			connection = ( HttpURLConnection )address.openConnection();
			connection.setRequestProperty( "Cookie", cookie );
			String sheet = getSheet( connection );
			String[][] MACFilteringArray = getTableArray( delHtml( sheet, 0 ));
			String sessionKey = getSessionKey( sheet );
			
			//объединяем массивы
			String[][] array = unionArray( DHCPArray, ARPArray, MACFilteringArray );
			
			//выбор устройства
			Scanner in = new Scanner( System.in );
			while ( 1 < 2 ) {
				outTable( array );
				System.out.println( array.length + ") update" );
				System.out.println( array.length + 1 + ") exit" );
				System.out.print( "> " );
				int num = in.nextInt();
				if (( num > 0 ) & ( num < array.length )) {
					if ( array[num][3].equals( "unblock" ) == true ) {
						for ( int inname = 0; 1 < 2; inname++ ) {
							boolean search = false;
							for ( int i = 1; i < MACFilteringArray.length; i++ ) {
								if ( MACFilteringArray[i][0].equals( Integer.toString( inname )) == true ) {
									search = true;
									break;
								}
							}
							if ( search == false ) {
								address = new URL( "http://192.168.1.1/scoutflt.cmd?action=add&fltName=" + inname + "&ipver=4&protocol=4&macAddr=" + array[num][1] + "&sessionKey=" + sessionKey );
								break;
							}
						}
					} else {
						String mac = array[num][1];
						for ( int i = 1; i < MACFilteringArray.length; i++ ) {
							if ( MACFilteringArray[i][3].equals( mac ) == true ) {
								String name = MACFilteringArray[i][0];
								address = new URL( "http://192.168.1.1/scoutflt.cmd?action=remove&rmLst=" + name + "&sessionKey=" + sessionKey );
								break;
							}
						}
					}
					//обновляем таблицу MACFilteringArray и получаем sessionKey
					connection = ( HttpURLConnection )address.openConnection();
					connection.setRequestProperty( "Cookie", cookie );
					sheet = getSheet( connection );
					MACFilteringArray = getTableArray( delHtml( sheet, 0 ));
					sessionKey = getSessionKey( sheet );
					array = unionArray( DHCPArray, ARPArray, MACFilteringArray );
				}
				if ( num == array.length ) {
					//обновляем таблицу DHCP
					address = new URL( "http://192.168.1.1/dhcpinfo.html" );
					connection = ( HttpURLConnection )address.openConnection();
					connection.setRequestProperty( "Cookie", cookie );
					DHCPArray = getTableArray( delHtml( getSheet( connection ), 0 ));
			
					//обновляем таблицу ARP
					address = new URL( "http://192.168.1.1/arpview.cmd" );
					connection = ( HttpURLConnection )address.openConnection();
					connection.setRequestProperty( "Cookie", cookie );
					ARPArray = getTableArray( delHtml( getSheet( connection ), 0 ));
			
					//обновляем таблицу MACFiltering
					address = new URL( "http://192.168.1.1/scoutflt.cmd?action=view" );
					connection = ( HttpURLConnection )address.openConnection();
					connection.setRequestProperty( "Cookie", cookie );
					sheet = getSheet( connection );
					MACFilteringArray = getTableArray( delHtml( sheet, 0 ));
					sessionKey = getSessionKey( sheet );
			
					//объединяем массивы
					array = unionArray( DHCPArray, ARPArray, MACFilteringArray );
				}
				if ( num == array.length + 1 ) {
					break;
				}
			}
			
			connection.disconnect();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	//получаем sessionKey
	public static String getSessionKey( String sheet ) {
		boolean found = false;
		String key = "";
		for ( int i = 0; i < sheet.length() - 13; i++ ) {
			String teg = sheet.substring( i, i + 13 );
			if ( teg.equals( "'&sessionKey=" ) == true ) {
				i += 13;
				found = true;
			}
			if ( found == true ) {
				teg = sheet.substring( i, i + 1 );
				if ( teg.equals( "'" ) == true ) {
					break;
				}
				key += teg;
			}
		}
		return key;
	}
	
	//объединяем таблицы и убираем повторения
	public static String[][] unionArray( String[][] array1, String[][] array2, String[][] array3 ) {
		String[][] unarray = new String[getNumLines( array1, array2 )][4];
		unarray[0][0] = "Hostname";
		unarray[0][1] = "MAC Address";
		unarray[0][2] = "IP Address";
		unarray[0][3] = "State";
		for ( int i = 1; i < array1.length; i++ ) {
			unarray[i][0] = array1[i][0];
			unarray[i][1] = array1[i][1];
			unarray[i][2] = array1[i][2];
			unarray[i][3] = "unblock";
			for ( int i2 = 1; i2 < array3.length; i2++ ) {
				if ( array1[i][1].equals( array3[i2][3] ) == true ) {
					unarray[i][3] = "block";
					break;
				}
			}
		}
		
		int t = 0;
		for ( int i = 1; i < array2.length; i++ ) {
			boolean search = false;
			for ( int i2 = 1; i2 < array1.length; i2++ ) {
				if ( array2[i][0].equals( array1[i2][2] ) == true ) {
					search = true;
					break;
				}
			}
			if ( search == false ) {
				unarray[array1.length + t][0] = "PC or service";
				unarray[array1.length + t][1] = array2[i][2];
				unarray[array1.length + t][2] = array2[i][0];
				unarray[array1.length + t][3] = "unblock";
				for ( int i2 = 1; i2 < array3.length; i2++ ) {
					if ( array2[i][2].equals( array3[i2][3] ) == true ) {
						unarray[array1.length + t][3] = "block";
						break;
					}
				}
				t += 1;
			}
		}
		return unarray;
	}
	
	//получаем количество строк в новом массиве после объединения и исключения повторений
	public static int getNumLines( String[][] array1, String[][] array2 ) {
		int numlines = array1.length;
		for ( int i = 1; i < array2.length; i++ ) {
			boolean search = false;
			for ( int i2 = 1; i2 < array1.length; i2++ ) {
				if ( array2[i][0].equals( array1[i2][2] ) == true ) {
					search = true;
					break;
				}
			}
			if ( search == false ) {
				numlines += 1;
			}
		}
		return numlines;
	}
	
	//преобразуем ArrayList в String[][] массив
	public static String[][] getTableArray( ArrayList<String> list ) {
		String firstline = list.get( 0 );
		int numst = 0;
		for ( int i = 0; i < firstline.length(); i++ ) {
			if ( firstline.charAt( i ) == '|' ) {
				numst += 1;
			}
		}
		
		String[][] array = new String[list.size()][numst];
		for ( int i = 0; i < list.size(); i++ ) {
			String line = list.get( i );
			String text = "";
			int col = 0;
			for ( int i2 = 0; i2 < line.length(); i2++ ) {
				if (( line.charAt( i2 ) != '|' ) & ( i2 != line.length() - 1 )) {
					text += line.charAt( i2 );
				} else {
					array[i][col] = text;
					col += 1;
					text = "";
					continue;
				}
			}
		}
		return array;
	}
	
	//вывод массива String[][]
	public static void outTable( String[][] array ) {
		int[] colsize = new int[array[0].length];
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				if ( colsize[i2] < array[i][i2].length()) {
					colsize[i2] = array[i][i2].length();
				}
			}
		}
		
		for ( int i = 0; i < array.length; i++ ) {
			if ( i != 0 ) {
				System.out.print( i + ") " + getOffset( i, array.length ));
			} else {
				System.out.print( "   " + getOffset( i, array.length ));
			}
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				System.out.print( array[i][i2] );
				for ( int i3 = array[i][i2].length(); i3 < colsize[i2]; i3++ ) {
					System.out.print( " " );
				}
				System.out.print( " | " );
			}
			System.out.println();
		}
	}
	
	//делаем отступы после номеров строки
	public static String getOffset( int number, int maxnumber ) {
		String num = Integer.toString( number );
		String numlines = Integer.toString( maxnumber );
		int numspace = numlines.length() - num.length();
		String offset = "";
		for ( int i = 0; i < numspace; i++ ) {
			offset += " ";
		}
		return offset;
	}
	
	//находим number таблицу и убираем html теги
	public static ArrayList<String> delHtml( String value, int number ) {
		ArrayList<String> lines = new ArrayList<String>();
		boolean found = false;
		int i = 0;
		String line = "";
		while ( 1 < 2 ) {
			String teg = value.substring( i, i + 6 );
			if ( teg.equals( "<table" ) == true ) {
				i += 6;
				found = true;
			}
			
			teg = value.substring( i, i + 7 );
			if ( teg.equals( "</table" ) == true ) {
				i += 7;
				if ( number == 0 ) {
					break;
				}
				number -= 1;
			}
			
			if (( found == true ) & ( number == 0 )) {
				teg = value.substring( i, i + 3 );
				if ( teg.equals( "<tr" ) == true ) {
					i += 3;
					line = "";
				}
				
				teg = value.substring( i, i + 4 );
				if ( teg.equals( "</tr" ) == true ) {
					i += 4;
					lines.add( line );
				}
				
				teg = value.substring( i, i + 3 );
				if ( teg.equals( "<td" ) == true ) {
					i += 3;
					boolean text = false;
					while ( 1 < 2 ) {
						teg = value.substring( i, i + 1 );
						if ( teg.equals( "<" ) == true ) {
							line += "|";
							i += 4;
							break;
						}
						if ( text == true ) {
							teg = value.substring( i, i + 6 );
							if ( teg.equals( "&nbsp;" ) == true ) {
								i += 6;
								line += " ";
								continue;
							}
							
							teg = value.substring( i, i + 5 );
							if ( teg.equals( "&nbsp" ) == true ) {
								i += 5;
								line += " ";
								continue;
							}
							
							line += value.charAt( i );
						}
						
						teg = value.substring( i, i + 1 );
						if ( teg.equals( ">" ) == true ) {
							text = true;
						}
						i += 1;
					}
				}
			}
			i += 1;
		}
		return lines;
	}
	
	//получаем html код страницы
	public static String getSheet( HttpURLConnection value ) {
		String sheet = "";
		try {
			BufferedReader sheetbuffer = new BufferedReader( new InputStreamReader( value.getInputStream()));
			boolean exit = false;
			while ( exit == false ) {
				String line = sheetbuffer.readLine();
				for ( int i = 0; i < line.length(); i++ ) {
					if ( i + 7 <= line.length()) {
						String text = line.substring( i, i + 7 );
						if ( text.equals( "</html>" ) == true ) {
							exit = true;
						}
					}
				}
				sheet += line;
			}
			sheetbuffer.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public static void outCookies( CookieManager value ) {
		List<HttpCookie> cookies = value.getCookieStore().getCookies();
		for ( int i = 0; i < cookies.size(); i++ ) {
			System.out.println( cookies.get( i ).getDomain());
			System.out.println( cookies.get( i ));
		}
	}
}