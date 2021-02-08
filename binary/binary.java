public class binary {
	public static void main( String[] args ) {
		System.out.print( "135.656 -> " + toTwo( "135.656", 5 ) + "\n" );
		System.out.print( "10111011 -> " + toTen( "10111011" ) + "\n" );
	}
	
	public static String toTwo( String a, int b ) {
		/*
		Метод переводит из десятичной в двоичную
		Пример: 135.656 -> 10000111.10100
		*/
		boolean minus = false;
		if ( a.charAt( 0 ) == '-' ) {
			a = a.substring( 1, a.length());
			minus = true;
		}
		String c = tothePoint( a );
		String d = afterPoint( a );
		int e = Integer.parseInt( c );
		double f = Double.parseDouble( "0." + d );
		String g = "";
		while ( 1 < 2 ) {
			g = e % 2 + g;
			if ( e / 2 != 1 ) {
				e = e / 2;
			} else {
				g = "1" + g;
				break;
			}
		}
		if ( c != "" ) {
			g += ".";
			for ( int i = 0; i < b; i++ ) {
				g += tothePoint( String.valueOf( f * 2 ));
				f = Double.parseDouble( "0." + afterPoint( String.valueOf( f * 2 )));
			}
		}
		if ( minus == true ) {
			g = "-" + g;
		}
		return g;
	}
	
	public static String toTen( String a ) {
		/*
		Метод переводит из двоичной в десятичную
		Пример: 10000111.10100 -> 135.656
		*/
		boolean minus = false;
		if ( a.charAt( 0 ) == '-' ) {
			a = a.substring( 1, a.length());
			minus = true;
		}
		String b = tothePoint( a );
		String c = afterPoint( a );
		String d = b + c;
		double e = 0;
		int f = b.length() - 1;
		String g = "";
		for ( int h = 0; h < d.length(); h++ ) {
			e += Integer.parseInt( Character.toString( d.charAt( h ))) * Math.pow( 2, f );
			f -= 1;
		}
		if ( c == "" ) {
			g = tothePoint( String.valueOf( e ));
		} else {
			g = String.valueOf( e );
		}
		if ( minus == true ) {
			g = "-" + g;
		}
		return g;
	}
	
	public static String afterPoint( String a ) {
		/*
		Метод возвращает цифры после запятой 
		Пример: 1010.0110110 -> 011011
		*/
		String newString = "";
		boolean pointf = false;
		for ( int i = 0; i < a.length(); i++ ) {
			if ( pointf == true ) {
				newString += Character.toString( a.charAt( i ));
			}
			if ( a.charAt( i ) == '.' ) pointf = true;
		}
		return newString;
	}
	
	public static String tothePoint( String a ) {
		/*
		Метод возвращает цифры до запятой 
		Пример: 1010.0110110 -> 011011
		*/
		String newString = "";
		boolean pointf = false;
		for ( int i = 0; i < a.length(); i++ ) {
			if ( a.charAt( i ) == '.' ) {
				break;
			} else {
				newString += Character.toString( a.charAt( i ));
			}
		}
		return newString;
	}
}