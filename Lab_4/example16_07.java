public class example16_07 {
	public static void main(String[] args) {
		//строка/столбец
		int[][] array = new int[5][5]; //создаем массив
		System.out.println("Вывод змейки");
		int rx = 0, ry = array.length - 1;
		boolean left = false;
		for ( int i = 0; i < array.length * array[0].length; i++ ) {
			if ( left == true ) rx -= 1;
			array[ry][rx] = i;
			
			//вывод массива после каждого изменения
			for ( int i2 = 0; i2 < array.length; i2++ ) {  
				for ( int j = 0; j < array[0].length; j++ ) {
					if ( array[i2][j] < 10 ) {
						System.out.print( " " + array[i2][j] + " " );
					} else {
						System.out.print( array[i2][j] + " " );
					}
				}
				System.out.println( "" );
			}
			System.out.println( "" );
			
			if ( left == false ) rx += 1;
			//повороты
			if ( rx == array[0].length ) {
				left = true;
				ry -= 1;
			}
			if ( rx == 0 ) {
				left = false;
				ry -= 1;
			}
		}
	}
}