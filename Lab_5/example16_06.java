class qwe_06 {
	private int min, max;
	qwe_06( int a, int b ) {
		sravnen( a, b );
	}
	qwe_06( int a ) {
		sravnen( a, 0 );
	}
	qwe_06() {
		sravnen( 0, 0 );
	}
	public void in( int a, int b ) {
		sravnen( a, b );
	}
	public void in( int a ) {
		sravnen( a, 0 );
	}
	public void out() {
		System.out.println( "min: " + min + " max: " + max );
	}
	private void sravnen( int a, int b ) {
		int mina, maxa;
		if ( a > b ) {
			maxa = a;
			mina = b;
		} else {
			maxa = b;
			mina = a;
		}
		if ( min > mina ) min = mina;
		if ( max < maxa ) max = maxa;
	}
}

public class example16_06 {
	public static void main( String[] args ) {
		qwe_06 myqwe = new qwe_06();
		myqwe.out();
		myqwe.in( 1, 2 );
		myqwe.out();
		myqwe.in( -4, 1 );
		myqwe.out();
		myqwe.in( 10, 0 );
		myqwe.out();
	}
}