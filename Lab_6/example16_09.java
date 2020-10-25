public class example16_09 {
	public static void main( String[] args ) {
		char[] arraychar = new char[] { 'a', 'b', 'c', 'd', 'e', 'z' };
		char[] newarraychar = charrevers( arraychar );
		for ( int i = 0; i < newarraychar.length; i++ ) {
			System.out.print( newarraychar[i] + " " );
		}
		System.out.println( "" );
	}
	public static char[] charrevers( char[] array ) {
		char[] newarray = new char[array.length];
		for ( int i = 0; i < array.length / 2; i++ ) {
			newarray[i] = array[array.length - 1 - i];
			newarray[newarray.length - 1 - i] = array[i];
		}
		//если колличество значений в массиве не четное
		if ( array.length % 2 != 0 ) {
			newarray[array.length / 2] = array[array.length / 2];
		}
		return newarray;
	}
}