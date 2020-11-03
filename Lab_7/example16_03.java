class qwe_03_01 {
	public int pole1;
	qwe_03_01( int param1 ) {
		pole1 = param1;
	}
	public void setPole( int param1 ) {
		pole1 = param1;
	}
	@Override
	public String toString() {
		String ClassNameAndFieldValue;
		ClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.pole1;
		return ClassNameAndFieldValue;
	}
}

class qwe_03_02 extends qwe_03_01 {
	public char pole2;
	qwe_03_02( int param1, char param2 ) {
		super( param1 );
		pole2 = param2;
	}
	public void setPole( int param1, char param2 ) {
		super.setPole( param1 );
		pole2 = param2;
	}
	@Override
	public String toString() {
		String ClassNameAndFieldValue;
		ClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.pole1 + "\n" + " pole2 = " + this.pole2;
		return ClassNameAndFieldValue;
	}
}

class qwe_03_03 extends qwe_03_02 {
	public String pole3;
	qwe_03_03( int param1, char param2, String param3 ) {
		super( param1, param2 );
		pole3 = param3;
	}
	public void setPole( int param1, char param2, String param3 ) {
		super.setPole( param1, param2 );
		pole3 = param3;
	}
	@Override
	public String toString() {
		String ClassNameAndFieldValue;
		ClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName() + "\n" + " pole1 = " + this.pole1 + "\n" + " pole2 = " + this.pole2 + "\n" + " pole3 = " + this.pole3;
		return ClassNameAndFieldValue;
	}
}

public class example16_03 {
	public static void main( String[] args ) {
		qwe_03_01 superClassObject1 = new qwe_03_01( 12 );
		System.out.println( superClassObject1.toString());
		
		qwe_03_02 superClassObject2 = new qwe_03_02( 12, 'a' );
		System.out.println( superClassObject2.toString());
		
		qwe_03_03 superClassObject3 = new qwe_03_03( 12, 'a', "Hello" );
		System.out.println( superClassObject3.toString());
	}
}