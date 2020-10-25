public class example16_04 {
	public static void main( String[] args ) {
		System.out.println( "factv1: " + factv1( 5 ));
		System.out.println( "factv2: " + factv2( 5 ));
	}
	public static double factv1( int n ) {
		double fact = n;
		int x = 0;
		if ( n % 2 == 0 ) {
			x = 2;
		} else {
			x = 1; 
		}
		for ( int i = x; i < n; i += 2 ) fact *= i;
		if ( n == 0 ) fact = 1;
		return fact;
	}
	public static double factv2( int n ) {
		if ( n < 3 ) {
			if ( n == 0 ) {
				return 1; 
			} else {
				return n;
			}
		} else {
			return n * factv2( n - 2 );
		}
	}
}