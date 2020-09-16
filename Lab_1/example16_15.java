import java.util.Scanner;
public class example16_15{
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.print("¬ведите число A: ");
int a = in.nextInt();
System.out.print("¬ведите число B: ");
int b = in.nextInt();
int otvet = a + b;
System.out.printf("A + B = %d\n", otvet);
in.close();
}
}