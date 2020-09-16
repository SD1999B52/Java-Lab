import java.util.Scanner;
import java.util.Calendar;
public class example16_13{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("Введите имя: ");
String name = in.nextLine();
System.out.print("Введите год рождения: ");
int god = in.nextInt();
int otvet = getCurrentYear() - god;
System.out.printf("Вас зовут %s и вам %d лет\n",name, otvet);
in.close();
}
public static int getCurrentYear() //Получить текущую дату
{
	int Date;
	int Month;
	int Year;
	Calendar calendar = Calendar.getInstance();
	Date = calendar.get(Calendar.DAY_OF_MONTH);
	Month = calendar.get(Calendar.MONTH);
	Year = calendar.get(Calendar.YEAR);
	return Year;
}
}