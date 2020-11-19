import java.util.Scanner;
import java.util.InputMismatchException;

public class example16_table_01_v2 {
	static int[] array = new int[10];
	static Scanner in = new Scanner( System.in );
	static int spnum = 0;
	
	public static void main( String[] args ) {
		inputarray();
		System.out.print( "Среднее значение среди положительных элементов: " + outsred() + "\n" );
	}
	
	public static void inputarray() {
		int i = 0;
		while ( i < array.length ) {
			System.out.print( "Введите число " + i + ": " );
			try {
				int num = in.nextInt();
				array[i] = num;
				if ( num >= 0 ) spnum += 1;
				i++;
			} catch ( InputMismatchException e ) {
				System.out.print( "Ошибка ввода\n" );
				in.next();
			}
		}
	}
	
	public static int outsred() {
		int summa = 0;
		if ( spnum > 0 ) {
			for ( int i = 0; i < array.length; i++ ) {
				if ( array[i] >= 0 ) summa += array[i];
			}
			int sred = summa / spnum;
			return sred;
		} else {
			throw new RuntimeException( "Нет положительных элементов" );
		}
	}
}