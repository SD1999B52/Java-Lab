import java.util.Scanner;

public class example16_02_01 {
	static StringBuffer twonum = new StringBuffer( "" );
	
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
        System.out.print( "Введите число: " );
        int num = in.nextInt();
		totwo( num );
		System.out.print( num + ">" + twonum + "\n" );
	}
	
	public static void totwo( int a ) {
		twonum.insert( 0, a % 2 + "" );
		if ( a / 2 != 1 ) {
			totwo( a / 2 );
		} else {
			twonum.insert( 0, "1" );
		}
	}
}