public class example16_08 {
	public static void main( String[] args ) {
		int[] arrayint = new int[] { 1, 2, 3, 9, 8, 3 };
		System.out.println( "Среднее значение: " + charcode( arrayint ));
	}
	public static double charcode( int[] array ) {
		double summa = 0;
		for ( int i = 0; i < array.length; i++ ) {
			summa += array[i];
		}
		return summa / array.length;
	}
}
