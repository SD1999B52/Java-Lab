import java.util.Scanner;
public class example16_10{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("¬ведите название текущего дн€ недели: ");
String ntdn = in.nextLine();
System.out.print("¬ведите название текущего мес€ца: ");
String mesats = in.nextLine();
System.out.print("¬ведите номер дн€ мес€ца: ");
int ndm = in.nextInt();
System.out.printf("%s %d %s \n", ntdn, ndm, mesats);
in.close();
}
}