import java.util.Scanner;
import java.util.InputMismatchException;

public class example16_table_03_v2 {
	static byte[] array = new byte[10];
	static Scanner in = new Scanner( System.in );
	
	public static void main( String[] args ) {
		inarray();
		outarraysum();
	}
	
	public static void inarray() {
		int i = 0;
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
	}
	
	public static void outarraysum() {
		int summa = 0;
		for ( int i = 0; i < array.length; i++ ) {
			summa += array[i];
		}
		System.out.print( "Сумма элементов массива: " + summa + "\n" );
	}
}