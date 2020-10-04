public class example16_03 {
	public static void main(String[] args) {
		int[][] array = new int[5][6];//создаем
		//заполняем
		for ( int i = 0; i < array.length; i++ ){  
			for ( int j = 0; j < array[i].length; j++ ) array[i][j] = 2;					 
		}
		//выводим
		for ( int i = 0; i < array.length; i++ ){  
			for ( int j = 0; j < array[i].length; j++ ) System.out.print( array[i][j] + " " );					 
			System.out.println(""); 
		}
	}
}