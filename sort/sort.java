/*
Сортировка вставками
*/
public class sort {
	public static void main( String[] args ) {
		int[] array = { 5, 9, 4, 6, -1, 8, 2, 7, 3 , 0 };
		for ( int i = 1; i < array.length; i++ ) {
			int number = array[i];
			for ( int i2 = i; i2 > 0; i2-- ) {
				if ( array[i2] < array[i2 - 1] ) {
					array[i2] = array[i2 - 1];
					array[i2 - 1] = number;
				}
			}
		}
		for ( int i = 0; i < array.length; i++ ) {
			System.out.print( array[i] + " " );
		}
	}
}