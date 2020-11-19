import java.util.Scanner;
import java.util.InputMismatchException;

public class example16_table_01_v1 {
	public static void main( String[] args ) {
		int[] array = new int[10];
		Scanner in = new Scanner( System.in );
		int i = 0, spnum = 0, summa = 0;
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
		if ( spnum > 0 ) {
			for ( i = 0; i < array.length; i++ ) {
				if ( array[i] >= 0 ) summa += array[i];
			}
			int sred = summa / spnum;
			System.out.print( "Среднее значение среди положительных элементов: " + sred + "\n" );
		} else {
			throw new RuntimeException( "Нет положительных элементов" );
		}
	}
}