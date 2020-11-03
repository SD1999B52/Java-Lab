class qwe_05_01 {
	private String pole1;
	qwe_05_01( String param1 ) {
		this.pole1 = param1;
	}
	public String getPole1() {
		return pole1;
	}
	@Override
	public String toString() {
		String superClassNameAndFieldValue;
		superClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.pole1;
		return superClassNameAndFieldValue;
	}
}

class qwe_05_02 extends qwe_05_01 {
	private int pole2;
	qwe_05_02( String param1, int param2 ) {
		super( param1 );
		this.pole2 = param2;
	}
	@Override
	public String toString() {
		String superClassNameAndFieldValue;
		superClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.getPole1() + "\n" + " pole2 = " + this.pole2;
		return superClassNameAndFieldValue;
	}
}

class qwe_05_03 extends qwe_05_01 {
	private char pole3;
	qwe_05_03( String param1, char param3 ) {
		super( param1 );
		this.pole3 = param3;
	}
	@Override
	public String toString() {
		String superClassNameAndFieldValue;
		superClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.getPole1() + "\n" + " pole3 = " + this.pole3;
		return superClassNameAndFieldValue;
	}
}

public class example16_05 {
	public static void main( String[] args ) {
		qwe_05_01 superClassObject1 = new qwe_05_01( "hello" );
		System.out.println( superClassObject1.toString());
		
		qwe_05_02 superClassObject2 = new qwe_05_02( "hello", 15 );
		System.out.println( superClassObject2.toString());
		
		qwe_05_03 superClassObject3 = new qwe_05_03( "hello", 'q' );
		System.out.println( superClassObject3.toString());
	}
}