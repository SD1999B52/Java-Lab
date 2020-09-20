package ex_4;
import java.util.Scanner;

public class lessons1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in = new Scanner( System.in );
			System.out.print("Ââåäèòå ÷èñëî: ");
			int number = in.nextInt();
			if (( number >= 5 ) & ( number <= 10 )) { 
				System.out.printf("×èñëî %d óäîâëåòâîğÿåò", number );
			} else {
				System.out.printf("×èñëî %d íåóäîâëåòâîğÿåò", number );
			}
			in.close();
	}

}
