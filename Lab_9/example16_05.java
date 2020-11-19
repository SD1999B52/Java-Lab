public class example16_05 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр RuntimeException с сообщением
			throw new RuntimeException( "ошибка" );
		} catch ( NullPointerException e ) { //исключение перехвачено
			//обработчик исключений типа NullPointerException
			System.out.println( "1" ); //исключение обработано
		}
		System.out.println( "2" );
	}
}