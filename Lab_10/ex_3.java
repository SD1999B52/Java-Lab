/*File:
Шолохов, Островский, Фет,
Пушкин, Лермонтов, Толстой, Аксаков,
Тургенев, Булгаков,
Достоевский
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

class ex_3 {
	public static void main( String[] args ) {
		try {
			BufferedReader in = new BufferedReader( new FileReader( "file1.txt" ));
			BufferedWriter out = new BufferedWriter( new FileWriter( "file2.txt" ));
			String line = in.readLine();
			
			int lineNum = 0;
			while ( line != null ) {
				String[] words = line.split( " " );
				
				ArrayList<String[]> lines = new ArrayList<String[]>();
				for ( int i = 0; i < words.length; i++ ) {
					if ( firstConsonant( words[i] ) == true ) {
						
						String[] inLines = new String[2];
						inLines[0] = Integer.toString( lineNum );
						inLines[1] = words[i];
						lines.add( inLines );
					}
				}
				
				for ( int i = 0; i < lines.size(); i++ ) {
					String[] inLines = lines.get( i );
					out.write( "Исходная строка: " + inLines[0] + " Выбрано слов: " + lines.size() + " Слово: " + inLines[1] + "\r\n" );
				}
				
				lineNum += 1;
				line = in.readLine();
			}
			
			out.close();
			in.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static boolean firstConsonant( String word ) {
		char[] consonants = {
			'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н',
			'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'
		};
		
		for ( int i = 0; i < consonants.length; i++ ) {
			if ( word.charAt( 0 ) == consonants[i] ) {
				return true;
			}
		}
		
		return false;
	}
}