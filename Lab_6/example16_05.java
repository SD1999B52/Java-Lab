public class example16_05 {
	public static void main( String[] args ) {
		System.out.println( "sumquadv1: " + sumquadv1( 5 ));
		System.out.println( "sumquadv2: " + sumquadv2( 5 ));
		System.out.println( "sumquadv3: " + sumquadv3( 5 ));
	}
	public static int sumquadv1( int n ) {
		int summa = 0;
		for ( int i = 1; i <= n; i++ ) summa += i * i;
		return summa;
	}
	public static int sumquadv2( int n ) {
		int summa = ( n * ( n + 1 ) * ( 2 * n + 1 )) / 6;
		return summa;
	}
	public static int sumquadv3( int n ) {
		int summa = 0;
        if ( n > 0 ) summa = n * n + sumquadv3( n - 1 );
        return summa;
	}
}