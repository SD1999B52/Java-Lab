public class example16_11 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			System.out.println( "0" );
			//брошено» исключение и создан экземпляр NullPointerException с сообщением
			throw new NullPointerException( "ошибка" );
		} catch ( NullPointerException e ) { //исключение перехвачено
			//обработчик исключений типа NullPointerException
			System.out.println( "1" ); //исключение обработано
		} finally { //выполняется всегда
			System.out.println( "2" );
		}
		System.out.println( "3" );
	}
}