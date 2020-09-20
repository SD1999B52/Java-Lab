package ex_1;
import java.util.Scanner;

public class lesson1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		System.out.print("Введите число: ");
		int number = in.nextInt();
		if ( number % 3 != 0 ) { 
			System.out.printf("Число %d не делится на 3", number );
		} else {
			System.out.printf("Число %d делится на 3", number );
		}
		in.close();
	}

}
