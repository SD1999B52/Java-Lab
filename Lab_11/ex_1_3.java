import java.io.IOException;
import java.io.Reader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.ByteArrayInputStream;

class ex_1_3 {
	public static void main( String[] args ) {
		try {
			//С потоком связан файл
			InputStream inFile = new FileInputStream( "file_1.txt" );
			Reader rFile = new InputStreamReader( inFile, "cp1251" );
			readAllByByte( rFile );
			System.out.print( "\n\n\n" );
			inFile.close();
			rFile.close();
			
			//С потоком связана интернет-страница
			InputStream inUrl = new URL( "http://google.com" ).openStream();
			Reader rUrl = new InputStreamReader( inUrl, "cp1251" );
			readAllByByte( rUrl );
			System.out.print( "\n\n\n" );
			inUrl.close();
			rUrl.close();
			
			//С потоком связан массив типа byte
			InputStream inArray = new ByteArrayInputStream( new byte[] { 5, 8, 3, 9, 11 });
			Reader rArray = new InputStreamReader( inArray, "cp1251" );
			readAllByByte( rArray );
			System.out.print("\n\n\n");
			inArray.close();
			rArray.close();
		} catch ( IOException e ) {
			System.out.println( "Ошибка: " + e );
		}
	}
	
	public static void readAllByByte( Reader in ) throws IOException {
		while ( true ) {
			int oneByte = in.read();
			if ( oneByte != -1 ) {
				System.out.print(( char ) oneByte );
			} else {
				System.out.print( "\n" + " конец " );
				break;
			}
		}
	}
}