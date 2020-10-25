public class example16_06 {
	public static void main( String[] args ) {
		int[] arrayint = new int[] { 1, 2, 3, 5, 6, 9 };
		int[] newarrayint = cnarray( arrayint, 2 );
		for ( int i = 0; i < newarrayint.length; i++ ) {
			System.out.print( newarrayint[i] + " " );
		}
		System.out.println( "" );
	}
	public static int[] cnarray( int[] array, int n ) {
		if ( n > array.length ) {
			return array;
		} else {
			int[] newarray = new int[n];
			for ( int i = 0; i < n; i++ ) {
				newarray[i] = array[i];
			}
			return newarray;
		} 
	}
}