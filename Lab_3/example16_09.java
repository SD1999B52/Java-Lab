import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class example16_09{
	public static void main( String[] args ) {
		Scanner id = new Scanner( System.in );
		System.out.print( "Введите размер массива: " );
		int size = id.nextInt();
		int[] nums = new int[size];
		int ind = 0, min = 200; //правильней было бы найти max но...
		Random random = new Random(); //Создание объекта класса Random для генерации "случайного" числа
		for ( int i = 0; i < nums.length; i++ ) {
			nums[i] = random.nextInt( 200 ); //присвоение i-тому элементу массива случайного значения [0,200)
			System.out.println( "Элемент массива [" + i + "] = " + nums[i] );
		}
		//нахождение минимального значени¤
		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] < min ) {
				min = nums[i];
				ind = i;
			}
		}
		System.out.println("------------------------");
		//поиск нескольких одинаковых min значений
		int a = 0; //колличество повторяющихся min значений
		String str = ""; //перечисление индексов одинаковых min значений
		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] == min ) {
				if ( a != 0 ) str += ",";
				a += 1;
				str += i;
			}
		}
		System.out.println( "Min элемент массива = " + min );
		System.out.println( "Колличество: " + a );
		System.out.println( "Индексы: " + str );
	}
}