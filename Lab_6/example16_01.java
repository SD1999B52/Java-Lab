class qwe_01 {
	private static char polechr = '0';
	private static String polestr = "0";
	public static void in( char text ) {
		polechr = text;
	}
	public static void in( String text ) {
		polestr = text;
	}
	public static void in( char[] text ) {
		String newtext = "";
		if ( text.length == 1 ) {
			polechr = text[0];
		} else {
			for ( int i = 0; i < text.length; i++ ) {
				newtext += text[i];
			}
			polestr = newtext;
		}
	}
	public static void out() {
		System.out.println( "char: " + polechr + "   string: " + polestr );
	}
	public static void peremnull() {
		polechr = '0';
		polestr = "0";
	}
}

public class example16_01 {
	public static void main( String[] args ) {
		char[] array1 = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
		char[] array2 = new char[]{'a'};
		qwe_01.in( array1 );
		qwe_01.out();
		
		qwe_01.peremnull();
		qwe_01.in( array2 );
		qwe_01.out();
		
		qwe_01.peremnull();
		qwe_01.in( "Hello" );
		qwe_01.out();
		
		qwe_01.peremnull();
		qwe_01.in( 'H' );
		qwe_01.out();
	}
}