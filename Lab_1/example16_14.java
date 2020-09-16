import java.util.Scanner;
import java.util.Calendar;
public class example16_14{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("Введите возраст: ");
int vozrast = in.nextInt();
int otvet = getCurrentYear() - vozrast;
System.out.printf("Вы родились в %d году\n", otvet);
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