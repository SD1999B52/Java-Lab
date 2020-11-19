public class example16_09 {
	public static int m() {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			return 55; //выход из метода и возврат значения
		} finally { //выполняется всегда
			System.out.println( "1" );
		}
	}
	
	public static void main( String[] args ) {
		System.out.println( m()); //вызов метода и возврат значения
	}
}