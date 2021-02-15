import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

class xml {
	public static void main( String[] args ) {
		ArrayList<String> sheet = getSheet( "example.xml" );
		
		//получаем реквизиты
		String[][] RequisiteArray = getRequisites( sheet, "date", "type", "author", "names", "input" );
		outArray( RequisiteArray );
		
		//получаем данные из таблицы Студенты
		String[][] StudentArray = getTable( sheet, "Students", "Student", "id", "name", "age" );
		outArray( StudentArray );
		
		//получаем данные из таблицы Предметы
		String[][] SubjectArray = getTable( sheet, "Academic_subjects", "Subject", "id", "name" );
		outArray( SubjectArray );
		
		//создаем XML файл
		String[][] tablesSettings = {
			{ "Students", "Student" },
			{ "Academic_subjects", "Subject" }
		};
		ArrayList<String> newsheet = createXML( RequisiteArray, tablesSettings, StudentArray, SubjectArray );
		XMLOut( newsheet, "outexample.xml" );
	}
	
	//запись в файл
	public static void XMLOut( ArrayList<String> sheet, String filename ) {
		try {
			BufferedWriter writefile = new BufferedWriter( new FileWriter( filename ));
			for ( int i = 0; i < sheet.size(); i++ ) {
				writefile.write( sheet.get( i ));
				if ( i != sheet.size() - 1 ) {
					writefile.newLine();
				}
			}
			writefile.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	//создаем XML
	public static ArrayList<String> createXML( String[][] requisites, String[][] settings, String[][] ... tables ) {
		ArrayList<String> newXML = new ArrayList<String>();
		newXML.add( "<?xml version=\"1.0\"?>" );
		newXML.add( "<root>" );
		for ( int i = 0; i < requisites[0].length; i++ ) {
			newXML.add( "\t" + "<" + requisites[0][i] + ">" + requisites[1][i] + "</" + requisites[0][i] + ">" );
		}
		for ( int i = 0; i < settings.length; i++ ) {
			newXML.add( "\t" + "<" + settings[i][0] + ">" );
			String[][] array = tables[i];
			for ( int i2 = 0; i2 < array.length - 1; i2++ ) {
				newXML.add( "\t\t" + "<" + settings[i][1] + ">" );
				for ( int i3 = 0; i3 < array[0].length; i3++ ) {
					newXML.add( "\t\t\t" + "<" + array[0][i3] + ">" + array[i2 + 1][i3] + "</" + array[0][i3] + ">" );
				}
				newXML.add( "\t\t" + "</" + settings[i][1] + ">" );
			}
			newXML.add( "\t" + "</" + settings[i][0] + ">" );
		}
		newXML.add( "</root>" );
		return newXML;
	}
	
	//получаем реквизиты
	public static String[][] getRequisites( ArrayList<String> sheet, String ... reqName ) {
		String[][] requisitesArray = new String[2][reqName.length];
		for ( int i = 0; i < reqName.length; i++ ) {
			requisitesArray[0][i] = reqName[i];
			requisitesArray[1][i] = getValue( sheet, reqName[i] ).get( 0 );
		}
		return requisitesArray;
	}
	
	//получаем таблицу
	public static String[][] getTable( ArrayList<String> sheet, String tableName, String unitName, String ... colName ) {
		ArrayList<String> tableList = getValue( sheet, tableName );
		ArrayList<String> unitList = getValue( tableList, unitName );
		String[][] tableArray = new String[unitList.size() + 1][colName.length];
		for ( int i = 0; i < colName.length; i++ ) {
			tableArray[0][i] = colName[i];
			ArrayList<String> colList = getValue( unitList, colName[i] );
			for ( int i2 = 0; i2 < unitList.size(); i2++ ) {
				tableArray[i2 + 1][i] = colList.get( i2 );
			}
		}
		return tableArray;
	}
	
	//вывод двумерного массива
	public static void outArray( String[][] array ) {
		//находим максимальное количество символов в столбце
		int[] colSize = new int[array[0].length];
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				if ( colSize[i2] < array[i][i2].length()) {
					colSize[i2] = array[i][i2].length();
				}
			}
		}
		
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				System.out.print( array[i][i2] );
				//добавляем отступы
				for ( int i3 = array[i][i2].length(); i3 < colSize[i2]; i3++ ) {
					System.out.print( " " );
				}
				System.out.print( " | " );
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//получаем внутренности тега(ов)
	public static ArrayList<String> getValue( ArrayList<String> sheet, String name ) {
		ArrayList<String> fromTag = new ArrayList<String>();
		String startTeg = "<" + name + ">";
		String finalTeg = "</" + name + ">";
		String text = "";
		boolean search = false;
		for ( int i = 0; i < sheet.size(); i++ ) {
			String line = sheet.get( i );
			for ( int i2 = 0; i2 < line.length(); i2++ ) {
				if ( i2 + startTeg.length() <= line.length()) {
					String teg = line.substring( i2, i2 + startTeg.length());
					if ( teg.equals( startTeg ) == true ) {
						i2 += startTeg.length();
						search = true;
					}
				}
				if ( i2 + finalTeg.length() <= line.length()) {
					String teg = line.substring( i2, i2 + finalTeg.length());
					if ( teg.equals( finalTeg ) == true ) {
						search = false;
						fromTag.add( text );
						text = "";
					}
				}
				if (( search == true ) & ( i2 < line.length())) {
					text += line.charAt( i2 );
				}
			}
		}
		return fromTag;
	}
	
	//получаем страницу XML
	public static ArrayList<String> getSheet( String filename ) {
		ArrayList<String> sheet = new ArrayList<String>();
		try {
			BufferedReader readfile = new BufferedReader( new FileReader( filename ));
			String line = readfile.readLine();
			while ( line != null ) {
				sheet.add( line );
				line = readfile.readLine();
			}
			readfile.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return sheet;
	}
}