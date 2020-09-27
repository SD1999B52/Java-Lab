import java.util.Scanner;

public class example16_06{
	public static void main( String[] args ) {
		char[] maschisel = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' }; //Вводимые значения могут быть только такими и >=0
		Scanner in = new Scanner( System.in );
		System.out.print( "Введите колличество чисел в массиве: " );
		String b = in.nextLine();
		boolean vvedensimvol = false;
		for ( int i = 0; i < b.length(); i++ ) {
			boolean bukva = true;
			char ch = b.charAt( i );
			for ( int i2 = 0; i2 < maschisel.length; i2++ ) {
				if ( ch == maschisel[i2] ) bukva = false;
			}
			if ( bukva == true ) {
				vvedensimvol = true;
				break;
			}
		}
		if ( vvedensimvol == false ) {
			int a = Integer.parseInt( b );
			int[] mas = new int[ a ];
			for ( int i = 0; i < a; i++ ) {
				mas[i] = i * 5 + 2;
				System.out.print( mas[i] + " " );
			}
			System.out.println( "" );
		} else {
			System.out.println( "Введено некорректное значение" );
		};
		in.close();
	}
}