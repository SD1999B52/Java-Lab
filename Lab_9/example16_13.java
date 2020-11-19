public class example16_13 {
	public static void main( String[] args ) {
		try {
			//блок кода, вызывающего ошибку
			int l = args.length;
			System.out.println( "размер массива = " + l );
			int h = 10 / l;
			args[l + 1] = "10";
		} catch ( ArithmeticException e ) { //исключение перехвачено
			//обработчик исключений типа ArithmeticException
			System.out.println( "Деление на ноль" ); //исключение обработано
		} catch ( ArrayIndexOutOfBoundsException e ) { //исключение перехвачено
			//обработчик исключений типа ArrayIndexOutOfBoundsException
			System.out.println( "Индекс не существует" ); //исключение обработано
		}
	}
}