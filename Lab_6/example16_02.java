class qwe_02 {
	private static int pole = 0;
	public static void out() {
		System.out.println( "pole: " + pole );
		pole += 1;
	}
}

public class example16_02 {
	public static void main( String[] args ) {
		qwe_02.out();
		qwe_02.out();
	}
}