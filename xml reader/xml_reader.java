import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

class xml_reader {
	public static void main( String[] args ) {
		ArrayList<String> sheet = getSheet( "example.xml" );
		
		//получаем реквизит names
		System.out.println( getValue( sheet, "names" ).get( 0 ) + "\n" );
		
		//получаем данные из таблицы Студенты
		ArrayList<String> Students = getValue( sheet, "Students" );
		ArrayList<String> Student = getValue( Students, "Student" );
		String[][] StudentArray = new String[Student.size()][3];
		ArrayList<String> idSt = getValue( Student, "id" );
		ArrayList<String> nameSt = getValue( Student, "name" );
		ArrayList<String> ageSt = getValue( Student, "age" );
		for ( int i = 0; i < Student.size(); i++ ) {
			StudentArray[i][0] = idSt.get( i );
			StudentArray[i][1] = nameSt.get( i );
			StudentArray[i][2] = ageSt.get( i );
		}
		outArray( StudentArray );
		
		System.out.println();
		
		//получаем данные из таблицы Предметы
		ArrayList<String> Academic_subjects = getValue( sheet, "Academic_subjects" );
		ArrayList<String> Subject = getValue( Academic_subjects, "Subject" );
		String[][] SubjectArray = new String[Subject.size()][2];
		ArrayList<String> idSub = getValue( Subject, "id" );
		ArrayList<String> nameSub = getValue( Subject, "name" );
		for ( int i = 0; i < Subject.size(); i++ ) {
			SubjectArray[i][0] = idSub.get( i );
			SubjectArray[i][1] = nameSub.get( i );
		}
		outArray( SubjectArray );
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
	}
	
	//получаем внутренности тега
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
			BufferedReader openfile = new BufferedReader( new FileReader( filename ));
			String line = openfile.readLine();
			while ( line != null ) {
				sheet.add( line );
				line = openfile.readLine();
			}
			openfile.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return sheet;
	}
}