import java.util.Scanner;
public class example16_11{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("¬ведите название мес€ца: ");
String mesats = in.nextLine();
System.out.print("¬ведите количество дней в мес€це: ");
int cdvm = in.nextInt();
System.out.printf("¬ %s %d дней \n", mesats, cdvm);
in.close();
}
}