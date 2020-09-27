import java.util.Scanner;

public class example16_04{
	public static void main( String[] args ) {
		int minf = 0, maxf = 0;
		Scanner in = new Scanner( System.in );
		System.out.print("Введите число A: ");
		int a = in.nextInt();
		System.out.print("Введите число B: ");
		int b = in.nextInt();
		if ( a > b ) { 
			maxf = a; 
			minf = b; 
		} else { 
			minf = a; 
			maxf = b; 
		}
		if ( a == b ) { 
			maxf = a;
			minf = b;
		}
		System.out.println( "max: " + Integer.toString( maxf ));
		System.out.println( "min: " + Integer.toString( minf ));
		for ( int i = minf; i <= maxf; i++ ) System.out.printf( i + " " );
		System.out.println( "" );
		in.close();
	}
}