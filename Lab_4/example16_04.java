public class example16_04 {
	public static void main(String[] args) {
		int razm = 10; //размер
		char[][] array = new char[razm][razm]; //создаем
		//заполняем
		for ( int i = 0; i < razm; i++ ) {  
			for ( int j = 0; j <= i; j++ ) array[i][j] = '+';					 
		}
		//выводим
		for ( int i = 0; i < razm; i++ ) {  
			for ( int j = 0; j < razm; j++ ) System.out.print( array[i][j] ); 					
			System.out.println("");
		}
	}
}