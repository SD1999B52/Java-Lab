import java.util.Scanner;
public class example16_16{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("¬ведите число A: ");
int chislo = in.nextInt();
int a = chislo - 1;
int b = chislo + 1;
int c = (int)Math.pow(( a + b ), 2 );
System.out.printf("A - 1 = %d\n", a);
System.out.printf("A = %d\n", chislo);
System.out.printf("A + 1 = %d\n", b);
System.out.printf("((A - 1)+(A + 1))^2 = %d\n", c);
in.close();
}
}