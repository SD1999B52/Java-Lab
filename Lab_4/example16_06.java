import java.util.Random;

public class example16_06 {
	public static void main(String[] args) {
		//3 - строка 5 - столбец
		int[][] array = new int[5][5]; //создаем
		int[][] newarray = new int[array.length - 1][array[0].length - 1];
		Random random = new Random();
		//получаем строку и столбец для удаления
		int delstroka = random.nextInt( array.length );
		int delstolb = random.nextInt( array[0].length );
		//заполняем исходный массив
		System.out.println("Исходный массив");
		for ( int i = 0; i < array.length; i++ ) {  
			for ( int j = 0; j < array[0].length; j++ ) {
				array[i][j] = random.nextInt( 10 );
				System.out.print( array[i][j] );
			}
			System.out.println("");			
		}
		System.out.println("Для удаления выбран столбец: " + Integer.toString( delstolb + 1 ) + " строка: " + Integer.toString( delstroka + 1 ));
		//удаляем столбец и строку
		int xr = 0, yr = 0;
		for ( int i = 0; i < array.length; i++ ) {  
			for ( int j = 0; j < array[0].length; j++ ) {
				if (( j != delstolb ) & ( i != delstroka )) {
					newarray[yr][xr] = array[i][j];
					xr += 1;
				}
			}
			xr = 0;
			if ( i != delstroka ) yr += 1;			
		}
		//выводим новый массив
		System.out.println("Новый массив");
		for ( int i = 0; i < newarray.length; i++ ) {  
			for ( int j = 0; j < newarray[0].length; j++ ) {
				System.out.print( newarray[i][j] );
			}
			System.out.println("");			
		}
	}
}