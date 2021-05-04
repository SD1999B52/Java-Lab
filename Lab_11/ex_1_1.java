import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class ex_1_1 {
	public static void main( String[] args ) throws IOException {
		Reader in = null;
		Writer out = null;
		try {
			in = new FileReader( "file_1.txt" );
			out = new FileWriter( "file_2.txt" );
			
			int oneByte;
			while(( oneByte = in.read()) != -1 ) {
				//out.write(( char )oneByte );//перезапись
				out.append(( char )oneByte );//добавление
				System.out.println(( char )oneByte );
			}
		} catch ( IOException e ) {
			System.out.println( "Ошибка!!!! " );
		} finally {
			in.close();
			out.close();
		}
	}
}