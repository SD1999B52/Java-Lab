public class example16_20
{
static double a = 10.0, b = 4.0;
public static void main(String[] args) {
int y = (int)Math.pow( a, b );
System.out.println("Катет а = " + a );
System.out.println("Катет b = " + b );
System.out.println("Гипотенуза с = " + hyp( a, b ));
System.out.println("a^b = " + y );
}
public static double hyp(double c, double d){
	double e = Math.sqrt( c * c + d * d );
	return e; 
}
}