public class example16_02 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр RuntimeException с сообщением
			throw new RuntimeException( "Непроверяемая ошибка" );
			System.out.println( "1" ); //недостижимый код
		} catch ( Exception e ) { //исключение перехвачено
			//обработчик исключений типа Exception
			System.out.println( "2 " + e ); //исключение обработано
		}
		System.out.println( "3" );
	}
}