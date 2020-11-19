import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.InputMismatchException;

public class example16_table_02_v2 {
	static Scanner in = new Scanner( System.in );
	static int[][] array = {{ 5, 7, 3, 17 },
							{ 7, 0, 1, 12 },
							{ 8, 1, 2, 3 }};
	
	public static void main( String[] args ) {
		incol();
	}
	
	public static void incol() {
		boolean ok = false;
		while ( ok == false ) {
			try {
				System.out.print( "Введите номер столбца: " );
				int i = in.nextInt();
				if ( outarray( i ) == true ) {
					ok = true;
				}
			} catch ( InputMismatchException e ) {
				System.out.print( "Ошибка ввода\n" );
				in.next();
			}
		}
	}
	
	public static boolean outarray( int a ) {
		try {
			for ( int i = 0; i < array.length; i++ ) {
				System.out.println( "" + array[i][a] );
			}
			return true;
		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.print( "Ошибка выхода за предел массива\n" );
			return false;
		}
	}
}