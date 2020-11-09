public class example16_01_05 {

	public static int f( int n ) {
		if ( n == 0 ) {
			return 0;
		} else {
			if ( n == 1 ) {
				return 1;
			} else {
				return f( n - 2 ) + f( n - 1 );
			}
		}
	}
	
	public static void main( String[] args ) {
		System.out.print( f( 20 ) + "\n" );
	}
}