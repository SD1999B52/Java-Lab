/*
Получение определителя матрицы N*N
*/

class determinant {
	static int[][] array = {
		{ 0, 3, -1, 2, 6 },
		{ 2, 1, 0, 0, 3 },
		{ -2, -1, 0, 2, 5 },
		{ -5, 7, 1, 1, 1 },
		{ 2, 0, 2, -2, 1 }
	};
	
	public static void main( String[] args ) {
		System.out.println( getDet( array ));
	}
	
	public static int getDet( int[][] matrix ) {
		int det = 0;
		for ( int i = 0; i < matrix.length; i++ ) {
			int[][] newMatrix = getMinor( i, matrix );
			if ( newMatrix.length != 1 ) {
				det += matrix[0][i] * Math.pow( -1, i + 2 ) * getDet( newMatrix );
			} else {
				det += matrix[0][i] * Math.pow( -1, i + 2 ) * newMatrix[0][0];
			}
		}
		return det;
	}
	
	public static int[][] getMinor( int column, int[][] matrix ) {
		int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];
		int num = 0;
		for ( int i = 0; i < matrix.length; i++ ) {
			if ( column != i ) {
				for ( int i2 = 0; i2 < newMatrix.length; i2++ ) {
					newMatrix[i2][num] = matrix[i2 + 1][i];
				}
				num += 1;
			}
		}
		return newMatrix;
	}
}