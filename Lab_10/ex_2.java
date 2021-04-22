/*File:
Hello
world
1.112 25.44 933.01 -34.89 99999.999
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class ex_2 {
	public static void main( String[] args ) {
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream( "file1.txt" ), "UTF8" ));
			BufferedWriter out = new BufferedWriter( new FileWriter( "file2.txt" ));
			String line1 = in.readLine();
			String line2 = in.readLine();
			String line3 = in.readLine();
			
			String[] lineNumbers = line3.split( " " );
			String newNumbers = "";
			for ( int i = 0; i < lineNumbers.length; i++ ) {
				double number = Double.parseDouble( lineNumbers[i] );
				if ( number >= 0 ) {
					if ( i != 0 ) {
						newNumbers += " ";
					}
					newNumbers += number;
				}
			}
			
			out.write( line2 + "\r\n" );
			out.write( newNumbers );
			
			out.close();
			in.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}