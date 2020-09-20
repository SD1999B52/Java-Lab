package ex_3;
import java.util.Scanner;

public class lesson1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		System.out.print("Введите число: ");
		int number = in.nextInt();
		if (( number % 4 == 0 ) & ( number > 10 )) { 
			System.out.printf("Число %d удовлетворяет", number );
		} else {
			System.out.printf("Число %d неудовлетворяет", number );
		}
		in.close();
	}

}
