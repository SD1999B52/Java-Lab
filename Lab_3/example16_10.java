import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class example16_10{
	public static void main( String[] args ) {
		Scanner id = new Scanner( System.in );
		System.out.print( "Введите размер массива: " );
		int size = id.nextInt();
		int[] nums = new int[size];
		Random random = new Random(); //Создание объекта класса Random дл¤ генерации "случайного" числа
		for ( int i = 0; i < nums.length; i++ ) {
			nums[i] = random.nextInt( 200 ); //Присвоение i-тому элементу массива случайного значени¤ [0,200)
			System.out.print( nums[i] + " " );
		}
		System.out.print( "\nСортировка по убыванию: " );
		nums = sortdown( nums ); // Сортировка массива по убыванию его элементов
		for ( int i = 0; i < nums.length; i++ ) {
			System.out.print( nums[i] + " " );
		}
		System.out.println( "" );
	}
	public static int[] sortdown( int[] mas ) {
		//метод сортировки по убыванию
		int[] numsdown = new int[mas.length];
		Arrays.sort( mas );
		for ( int i = 0; i < mas.length; i++ ) {
			numsdown[i] = mas[ mas.length - i - 1 ];
		}
		return numsdown;
	}
}