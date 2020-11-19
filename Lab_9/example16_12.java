public class example16_12 {
	public static void m( String str, double chislo ) {
		if ( str == null ) {
			//брошено» исключение и создан экземпляр IllegalArgumentException с сообщением
			throw new IllegalArgumentException( "Строка введена неверно" );
		}
		if ( chislo > 0.001 ) {
			//брошено» исключение и создан экземпляр IllegalArgumentException с сообщением
			throw new IllegalArgumentException( "Неверное число" );
		} 
	}
	
	public static void main( String[] args ) {
		m( null, 0.000001 ); //вызов метода
	}
}