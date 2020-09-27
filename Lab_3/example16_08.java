public class example16_08{
	public static void main( String[] args ) {
		char[] maschisel = new char[11];
		char[] masglas = { 'A', 'E', 'I', 'O', 'U' }; //массив с гласными буквами
		int c = 0;
		for ( int i = 65; i <= 90; i++ ) {
			char b = (char)( i ); //перевод кода символа в символ;
			if (( massearch( masglas, b ) == false ) & ( c < maschisel.length )) {
				maschisel[c] = b;
				System.out.print( maschisel[c] + " " );
				c += 1;
			}
		}
		System.out.println( "" );
	}
	public static boolean massearch( char[] mass, char bukva ) {
		boolean estvmass = false;
		for ( int i = 0; i < mass.length; i++ ) {
			if ( bukva == mass[i] ) {
				estvmass = true;
				break;
			}
		}
		return estvmass;
	}
}