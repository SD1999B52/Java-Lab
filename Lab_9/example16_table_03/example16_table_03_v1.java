import java.util.Scanner;
import java.util.InputMismatchException;

public class example16_table_03_v1 {
	public static void main( String[] args ) {
		byte[] array = new byte[10];
		Scanner in = new Scanner( System.in );
		int i = 0, summa = 0;
		while ( i < array.length ) {
			try {
				System.out.print( "Введите значение " + i + ": " );
				byte num = in.nextByte();
				array[i] = num;
				i++;
			} catch ( InputMismatchException e ) {
				System.out.print( "Ошибка ввода\n" );
				in.next();
			}
		}
		for ( i = 0; i < array.length; i++ ) {
			summa += array[i];
		}
		System.out.print( "Сумма элементов массива: " + summa + "\n" );
	}
}