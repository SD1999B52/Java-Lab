public class example16_01 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр RuntimeException с сообщением
			throw new RuntimeException( "Непроверяемая ошибка" );
		} catch ( RuntimeException e ) { //исключение перехвачено
			//обработчик исключений типа RuntimeException
			System.out.println( "1 " + e ); //исключение обработано
		}
		System.out.println( "2" );
	}
}