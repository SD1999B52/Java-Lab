public class example16_10 {
	public static int m() {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			return 15; //выход из метода и возврат значения
		} finally { //выполняется всегда
			System.out.println( "1" );
			return 20; //выход из метода и возврат значения
		}
	}
	
	public static void main( String[] args ) {
		System.out.println( m()); //вызов метода и возврат значения
	}
}