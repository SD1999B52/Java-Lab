import java.util.Scanner;

public class example16_03{
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите колличество чисел: ");
		int schisel = in.nextInt();
		fibfor( schisel ); //Через for
		fibwhile( schisel ); //Через while
		fibdowhile( schisel ); //Через do-while
		in.close();
	}
	public static void fibfor( int n ) {
		int a = 1, b = 0, c = 0;
		for ( int i = 0; i < n; i++ ) {
			c = a + b;
			a = b;
			b = c;
			System.out.printf( c + " " );
		}
		System.out.println( "" );
	}
	public static void fibwhile( int n ) {
		int i = 0, a = 1, b = 0, c = 0;
		while ( i < n ) {
			c = a + b;
			a = b;
			b = c;
			System.out.printf( c + " " );
			i++;
		}
		System.out.println( "" );
	}
	public static void fibdowhile( int n ) {
		int i = 0, a = 1, b = 0, c = 0;
		do {
			c = a + b;
			a = b;
			b = c;
			System.out.printf( c + " " );
			i++;
		} while ( i < n );
		System.out.println( "" );
	}
}