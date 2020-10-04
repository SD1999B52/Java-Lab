import java.util.Random;

public class example16_05 {
	public static void main(String[] args) {
		int[][] array = new int[3][5]; //создаем
		int[][] newarray = new int[array[0].length][array.length];
		Random random = new Random();
		//заполняем
		System.out.println("Созданный массив: ");
		for ( int i = 0; i < array.length; i++ ) {  
			for ( int j = 0; j < array[0].length; j++ ) {
				array[i][j] = random.nextInt( 10 );
				System.out.print( array[i][j] );
			}
			System.out.println("");			
		}
		//переворот
		System.out.println("Новый массив: ");
		for ( int i = 0; i < newarray.length; i++ ) {  
			for ( int j = 0; j < newarray[0].length; j++ ) {
				newarray[i][j] = array[j][i];
				System.out.print( newarray[i][j] );
			}
			System.out.println("");			
		}
	}
}