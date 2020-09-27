public class example16_07{
	public static void main( String[] args ) {
		int a = 10; //размер массива указывается переменной
		char[] maschisel = new char[a];
		for ( int i = 0; i < a; i++ ) {
			maschisel[i] = (char)( 97 + i * 2 ); //перевод кода символа в символ;
			System.out.print( maschisel[i] + " " ); //вывод в прямом виде
		}
		System.out.println( "" );
		for ( int i = 0; i < a; i++ ) System.out.print(( maschisel[a - i - 1] + " ")); //вывод в обратном виде
		System.out.println( "" );
	}
}