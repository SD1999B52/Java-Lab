class qwe_04 {
	qwe_04( int ch, char si ) {
		System.out.println( "Целое число : " + ch );
		System.out.println( "Символ: " + si );
		System.out.println( "Код символа: " + (int)si );
	}
	qwe_04( double chd ) {
		boolean naideno = false;
		char si = (char)((int)chd );
		//получяем значение после запятой два или один знак
		String chislovstroke = Double.toString( chd );
		String newchislo = "";
		int i2 = 2; //колличество чисел после запятой
		for( int i = 0; i < chislovstroke.length(); i++ ) {
			if (( naideno == true ) & ( i2 != 0 )) {
				newchislo += chislovstroke.charAt( i );
				i2 -= 1;
			}
			if ( chislovstroke.charAt( i ) == '.' ) naideno = true;
		}
		int ch = Integer.parseInt( newchislo );
		System.out.println( "Целое число : " + ch );
		System.out.println( "Символ: " + si );
		System.out.println( "Код символа: " + (int)chd );
	}
}

public class example16_04 {
	static int chislo = 12;
	static char simvol = 'A';
	static double chislod = 65.1267;
	public static void main(String[] args) {
		qwe_04 myqwe = new qwe_04( chislod );
		//qwe_04 myqwe = new qwe_04( chislo, simvol );
	}
}