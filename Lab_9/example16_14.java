public class example16_14 {
	//обработчик исключений типа ArithmeticException
	//trows для предупреждения, о том что метод может выбросить исключение
	public static void m( int x ) throws ArithmeticException {
		int h = 10 / x;
	}
	
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			int l = args.length; //количество значений в массиве
			System.out.println( "Размер массива = " + l );
			m( l ); //вызов метода
		} catch ( ArithmeticException e ) { //исключение перехвачено
			//обработчик исключений типа ArithmeticException
			System.out.println( "Ошибка: деление на ноль" ); //исключение обработано
		}
	}
}