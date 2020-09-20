package ex_10;
import java.util.Scanner;
import java.lang.String;

public class lesson1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner( System.in );
		System.out.print("Введите число: ");
		int number = in.nextInt();
		String convert = Integer.toOctalString( number );
		String otvet = convert.substring( convert.length() - 1 );
		System.out.printf("Число в десятичной: %s в восмеричной: %s вторая справа: %s", number, convert, otvet  );
		in.close();
	}

}
