import java.util.Scanner;
import java.util.ArrayList;

public class example16_03_01 {
	static Scanner in = new Scanner( System.in );
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main( String[] args ) {
		arrayin( 5 );
		arrayout();
		
	}
	
	public static void arrayout() {
		arrayout( 0 );
	}
	
	public static void arrayout( int i ) {
		if ( i != array.size()) {
			System.out.print( array.get( i ) + " " );
			arrayout( i + 1 );
		}
	}
	
	public static void arrayin( int i ) {
		if ( i > 0 ) {
			System.out.print( "Число " + array.size() + ">" );
			array.add( in.nextInt());
			arrayin( i - 1 );
		}
	}
}