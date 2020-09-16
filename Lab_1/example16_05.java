import java.util.Scanner;
public class example16_05{
public static void main(String[] args) {	
Scanner in = new Scanner(System.in);
System.out.print("Введите имя: ");
String name = in.nextLine();
System.out.print("Введите возраст: ");
int age = in.nextInt();
System.out.print("Введите рост: ");
float height = in.nextFloat();
System.out.printf("Имя: %s Возраст: %d Рост: %.2f \n", name, age, height);
in.close();
}
}