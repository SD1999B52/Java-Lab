public class example16_06 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр NullPointerException с сообщением
			throw new NullPointerException( "ошибка" );
		} catch ( ArithmeticException e ) { //исключение перехвачено
			//обработчик исключений типа ArithmeticException
			System.out.println( "1" ); //исключение обработано
		} catch ( RuntimeException e ) { //исключение перехвачено
			//обработчик исключений типа RuntimeException
			System.out.println( "2" ); //исключение обработано
		} catch ( Exception e ) { //исключение перехвачено
			//обработчик исключений типа Exception
			System.out.println( "3" ); //исключение обработано
		}
		System.out.println( "4" );
	}
}