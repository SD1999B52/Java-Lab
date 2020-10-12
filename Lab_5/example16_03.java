class qwe_03 {
	//без передачи аргументов
	qwe_03() {
		System.out.println("Нет аргуменов");
	}
	//с передачей одного аргумента
	qwe_03( int arg1 ) {
		System.out.println( arg1 + " ");
	}
	//с передачей двух аргументов
	qwe_03( int arg1, int arg2 ) {
		System.out.println( arg1 + " " + arg2 );
	}
}

public class example16_03 {
	static int arg1 = 1, arg2 = 2;
	public static void main( String[] args ) {
		qwe_03 myqwe = new qwe_03();
		qwe_03 myqwe1 = new qwe_03( 1 );
		qwe_03 myqwe2 = new qwe_03( 1, 2 );
	}
}