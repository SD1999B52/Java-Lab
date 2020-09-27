import java.util.Scanner;

public class example16_01{
	public static void main(String[] args) {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите число 1-7: ");
		int number = in.nextInt();
		switch( number ) {
			case 1: 
				System.out.println("Понедельник");
				break;
			case 2: 
				System.out.println("Вторник");
				break;
			case 3: 
				System.out.println("Среда");
				break;
			case 4: 
				System.out.println("Четверг");
				break;
			case 5: 
				System.out.println("Пятница");
				break;
			case 6: 
				System.out.println("Суббота");
				break;
			case 7: 
				System.out.println("Воскресение");
				break;
			default: 
				System.out.println("Введено некорректное значение");
				break;
		}
		in.close();
	}
}