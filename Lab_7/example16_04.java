class qwe_04_01 {
	public char pole1;
	qwe_04_01( char param1 ) {
		this.pole1 = param1;
	}
	qwe_04_01( qwe_04_01 ob ) {
        this.pole1 = ob.pole1;
    }
	@Override
	public String toString() {
		return this.pole1 + "\n";
	}
}

class qwe_04_02 extends qwe_04_01 {
	public String pole2;
	qwe_04_02( char param1, String param2 ) {
		super( param1 );
		this.pole2 = param2;
	}
	qwe_04_02( qwe_04_02 ob ) {
		super( ob.pole1 );
		this.pole2 = ob.pole2;
    }
	@Override
	public String toString() {
		return super.toString() + this.pole2 + "\n";
	}
}

class qwe_04_03 extends qwe_04_02 {
	public int pole3;
	qwe_04_03( char param1, String param2, int param3 ) {
		super( param1, param2 );
		this.pole3 = param3;
	}
	qwe_04_03( qwe_04_03 ob ) {
		super( ob.pole1, ob.pole2 );
		this.pole3 = ob.pole3;
    }
	@Override
	public String toString() {
		return super.toString() + this.pole3 + "\n";
	}
}

public class example16_04 {
	public static void main( String[] args ) {
		qwe_04_03 superClassObject1 = new qwe_04_03( 'q', "hello", 23 );
		System.out.println( superClassObject1.toString());
		
		qwe_04_03 superClassObject2 = new qwe_04_03( superClassObject1 );
		System.out.println( superClassObject2.toString());
	}
}