public class example16_01_04 {

	public static int fact(	int n ) {
		int result;
		if ( n == 1 ) {
			return 1;
		} else {
			result = fact( n - 1 ) * n;
			return result;
		}
	}
	
	public static void main( String[] args ) {
		System.out.print( fact(	5 ) + "\n" );
	}
}