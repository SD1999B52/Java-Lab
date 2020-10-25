public class example16_10 {
	public static void main( String[] args ) {
		int[] newarrayint = charrevers( 1, 2, 6, 2, 5, 3, 0 );
		System.out.println( "max: " + newarrayint[0] + "   min: " + newarrayint[1] );
	}
	public static int[] charrevers( int ... array ) {
		int[] newarray = new int[2];
		newarray[0] = array[0];
		newarray[1] = array[0];
		for ( int i = 0; i < array.length; i++ ) {
			if ( array[i] > newarray[0] ) newarray[0] = array[i]; //max
			if ( array[i] < newarray[1] ) newarray[1] = array[i]; //min
		}
		return newarray;
	}
}