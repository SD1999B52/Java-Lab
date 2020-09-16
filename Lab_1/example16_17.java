import java.util.Scanner;
public class example16_17{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("¬ведите число A: ");
int a = in.nextInt();
System.out.print("¬ведите число B: ");
int b = in.nextInt();

int summa = a + b;
int raznosta = a - b;
int raznostb = b - a;
System.out.printf("A + B = %d\n", summa);
System.out.printf("A - B = %d\n", raznosta);
System.out.printf("B - A = %d\n", raznostb);
in.close();
}
}