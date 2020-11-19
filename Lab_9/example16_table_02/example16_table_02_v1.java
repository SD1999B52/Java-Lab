import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.InputMismatchException;

public class example16_table_02_v1 {
	public static void main( String[] args ) {
		int[][] array = {{ 5, 7, 3, 17 },
						 { 7, 0, 1, 12 },
						 { 8, 1, 2, 3 }};
		Scanner in = new Scanner( System.in );
		boolean ok = false;
		while ( ok == false ) {
			try {
				System.out.print( "Введите номер столбца: " );
				int i = in.nextInt();
				for ( int i2 = 0; i2 < array.length; i2++ ) {
					System.out.println( "" + array[i2][i] );
				}
				ok = true;
			} catch ( ArrayIndexOutOfBoundsException e ) {
				System.out.print( "Ошибка выхода за предел массива\n" );
			} catch ( InputMismatchException e ) {
				System.out.print( "Ошибка ввода\n" );
				in.next();
			}
		}
	}
}