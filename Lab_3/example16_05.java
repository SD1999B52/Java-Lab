import java.util.Scanner;

public class example16_05{
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите количество чисел: ");
		int a = in.nextInt();
		int summa = 0;
		String summalt = "";
		for ( int i = 0; i < a; i++ ) {
			System.out.print("Введите число: " + Integer.toString( i ) + ": ");
			int b = in.nextInt();
			if ( ! (( b % 5 == 2 ) || ( b % 3 == 1 ))) continue;
			if ( i != 0 ) summalt += " + ";
			summalt += Integer.toString( b );
			summa += b;
		}
		System.out.println( summalt + " = " + Integer.toString( summa ));
		in.close();
	}
}