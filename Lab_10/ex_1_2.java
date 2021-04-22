import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.net.URL;

class ex_1_2 {
	public static void main( String[] args ) {
		try {
			InputStream inFile = new FileInputStream( "file.txt" );
			readAllByByte( inFile );
			System.out.println( "\n\n\n" );
			inFile.close();
		
			InputStream inUrl = new URL( "http://google.com" ).openStream();
			readAllByByte( inUrl );
			System.out.println( "\n\n\n" );
			inUrl.close();
		
			InputStream inArray = new ByteArrayInputStream( new byte[] { 7, 9, 3, 7, 4 });
			readAllByByte( inArray );
			System.out.println( "\n\n\n" );
			inArray.close();
		} catch ( IOException e ) {
			System.out.println( "Ошибка: " + e );
		}
	}
	
	public static void readAllByByte( InputStream in ) throws IOException {
		while ( true ) {
			int oneByte = in.read();
			if ( oneByte != -1 ) {
				System.out.print((char) oneByte );
			} else {
				System.out.print( "\n" + "end" );
				break;
			}
		}
	}
}