public class example16_08 {
	public static int m() {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр RuntimeException
			throw new RuntimeException();
		} finally { //выполняется всегда
			System.out.println( "1" );
		}
	}
	
	public static void main( String[] args ) {
		System.out.println( m()); //вызов метода и возврат значения
	}
}