class qwe_05 {
	private int pole;
	public void in() {
		pole = 0;
	}
	public void in( int chd ) {
		if ( chd > 100 ) {
			chd = 100;
		} else {
			pole = chd;
		}
	}
	public int out() {
		return pole;
	}
	qwe_05() {
		pole = 0;
	}
	qwe_05( int chd ) {
		if ( chd > 100 ) {
			chd = 100;
		} else {
			pole = chd;
		}
	}
}

public class example16_05 {
	public static void main(String[] args) {
		qwe_05 myqwe = new qwe_05();
		myqwe.in( 10 );
		System.out.println( myqwe.out());
	}
}