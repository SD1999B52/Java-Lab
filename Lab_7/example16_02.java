class qwe_02_01 {
	private String stroka1;
	qwe_02_01( String text ) {
		this.stroka1 = text;
	}
	public void setStroka( String text ) {
		this.stroka1 = text;
	}
	public void setStroka() {
		this.stroka1 = "";
	}
	public String getStroka() {
		return "stroka1: " + stroka1;
	}
	public int getLengthStroka() {
		return stroka1.length();
	}
	@Override
	public String toString() {
		String ClassNameAndFieldValue;
		ClassNameAndFieldValue = "Class name: " + this.getClass().getSimpleName();
		return ClassNameAndFieldValue;
	}
}

class qwe_02_02 extends qwe_02_01 {
	public int stroka2;
	qwe_02_02( int param, String text ) {
		super( text );
		stroka2 = param;
	}
	@Override
	public void setStroka() {
		super.setStroka();
		stroka2 = 0;
	}
	@Override
	public void setStroka( String text ) {
		super.setStroka( text );
		stroka2 = 0;
	}
	public void setStroka( int param ) {
		super.setStroka();
		stroka2 = param;
	}
	public void setStroka( String text, int param ) {
		super.setStroka( text );
		stroka2 = param;
	}
	@Override
	public String getStroka() {
		String text = super.getStroka() + "    stroka2: " + stroka2;
		return text;
	}
}

public class example16_02 {
	public static void main( String[] args ) {
		qwe_02_01 superClassObject1 = new qwe_02_01( "Суперкласс" );
		String className1 = superClassObject1.toString();
		System.out.println( className1 + "   length: " + superClassObject1.getLengthStroka() + "   " + superClassObject1.getStroka());
		
		qwe_02_02 superClassObject2 = new qwe_02_02( 5, "Подкласс" );
		String className2 = superClassObject2.toString();
		System.out.println( className2 + "   length: " + superClassObject2.getLengthStroka() + "   " + superClassObject2.getStroka());
	}
}