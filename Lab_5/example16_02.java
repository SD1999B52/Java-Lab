class qwe_02 {
	public char simbolA, simbolB;
	public void out() {
		int a = (int)simbolA;		
		int b = (int)simbolB;
		for ( int i = a; i <= b; i++ ) System.out.print((char)i );
		System.out.println("");
	}
}

public class example16_02 {
	public static void main(String[] args) {
		qwe_02 myqwe = new qwe_02();
		myqwe.simbolA = 'A';
		myqwe.simbolB = 'D';
		myqwe.out();
	}
}