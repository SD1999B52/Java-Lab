public class example16_07 {
	public static void main( String[] args ) {
		char[] arraychar = new char[] { 'a', 'b', 'c', 'd', 'e', 'z' };
		int[] arrayint = charcode( arraychar );
		for ( int i = 0; i < arrayint.length; i++ ) {
			System.out.print( arrayint[i] + " " );
		}
		System.out.println( "" );
	}
	public static int[] charcode( char[] array ) {
		int[] newarray = new int[array.length];
		for ( int i = 0; i < array.length; i++ ) {
			newarray[i] = (int)array[i];
		}
		return newarray;
	}
}