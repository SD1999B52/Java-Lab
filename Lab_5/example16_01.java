class qwe_01 {
	private char pole;
	public void in( char text ) {
		pole = text;
	}
	public void out1() {
		System.out.println((int)pole );
	}
	public void out2() {
		System.out.println( "Код символа " + pole + " " + (int)pole );
	}
}

public class example16_01 {
	public static void main(String[] args) {
		qwe_01 myqwe = new qwe_01();
		myqwe.in( 'q' );
		myqwe.out2();
	}
}