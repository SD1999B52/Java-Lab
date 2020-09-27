import java.util.Scanner;

public class example16_02{
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите название дня недели Напр. pn, vt, sr, ch, pt, su, vs: ");
		String dennedeli = in.nextLine();
		cherezif( dennedeli ); //Через if
		//cherezswitch( dennedeli ); //Через switch
		in.close();
	}
	public static void cherezif( String text ) {
		String otvet = "Такого дня нет";
		if ( text.equals( "pn" )) otvet = "Понедельник - 1";
		if ( text.equals( "vt" )) otvet = "Вторник - 2";
		if ( text.equals( "sr" )) otvet = "Среда - 3";
		if ( text.equals( "ch" )) otvet = "Четверг - 4";
		if ( text.equals( "pt" )) otvet = "Пятница - 5";
		if ( text.equals( "su" )) otvet = "Суббота - 6";
		if ( text.equals( "vs" )) otvet = "Воскресение - 7";
		System.out.println( otvet );
	}
	public static void cherezswitch( String text ) {
		switch( text ) {
			case "pn": 
				System.out.println("Понедельник - 1");
				break;
			case "vt": 
				System.out.println("Вторник - 2");
				break;
			case "sr": 
				System.out.println("Среда - 3");
				break;
			case "ch": 
				System.out.println("Четверг - 4");
				break;
			case "pt": 
				System.out.println("Пятница - 5");
				break;
			case "su": 
				System.out.println("Суббота - 6");
				break;
			case "vs": 
				System.out.println("Воскресение - 7");
				break;
			default: 
				System.out.println("Такого дня нет");
				break;
		}
	}
}