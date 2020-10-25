class qwe_03 {
	public static int max( int ... array ) {
		int max = array[0];
		for ( int i = 0; i < array.length; i++ ) {
			if ( array[i] > max ) max = array[i];
		}
		return max;
	}
	public static int min( int ... array ) {
		int min = array[0];
		for ( int i = 0; i < array.length; i++ ) {
			if ( array[i] < min ) min = array[i];
		}
		return min;
	}
	public static double sred( int ... array ) {
		double sred = 0, summa = 0;
		for ( int i = 0; i < array.length; i++ ) {
			summa += array[i];
		}
		sred = summa / array.length;
		return summa / array.length;
	}
}

public class example16_03 { 
	public static void main( String[] args ) {
		int[] array1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println( "max: " + qwe_03.max( array1 ));
		System.out.println( "min: " + qwe_03.min( array1 ));
		System.out.println( "sred: " + qwe_03.sred( array1 ));
		System.out.println( "max: " + qwe_03.max( 1, 2 ));
		System.out.println( "sred: " + qwe_03.sred( 1 ));
	}
}