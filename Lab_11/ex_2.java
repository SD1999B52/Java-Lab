/*File:
Твардовский, Шолохов, Островский, Фет,
Пушкин, Лермонтов, Толстой, Аксаков,
Тургенев, Булгаков, Тютчев,
Достоевский
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

class ex_2 {
	public static void main( String[] args ) {
		try {
			BufferedReader in = new BufferedReader( new FileReader( "file_1.txt" ));
			BufferedWriter out = new BufferedWriter( new FileWriter( "file_2.txt" ));
			String line = in.readLine();
			
			String firstWord = "";
			
			int lineNum = 0;
			while ( line != null ) {
				String[] words = line.split( " " );
				
				if ( firstWord.equals( "" ) == true ) {
					firstWord = words[0];
				}
				
				ArrayList<String[]> lines = new ArrayList<String[]>();
				for ( int i = 0; i < words.length; i++ ) {
					if ( firstWord.charAt( 0 ) == words[i].charAt( 0 )) {
						
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
}