class qwe_01_01 {
	private String stroka1;
	qwe_01_01( String text ) {
		this.stroka1 = text;
	}
	@Override
	public String toString() {
		String superClassNameAndFieldValue;
		superClassNameAndFieldValue = "super" + "\n" + " Class name: " + this.getClass().getSimpleName() + "\n" + " stroka1 = " + this.getStroka1();
		return superClassNameAndFieldValue;
	}
	public String getStroka1() {
		return stroka1;
	}
}

class qwe_01_02 extends qwe_01_01 {
	private String stroka2;
	qwe_01_02( String text ) {
		super( text );
	}
	qwe_01_02( String text1, String text2 ) {
		super( text1 );
		this.stroka2 = text2;
	}
	@Override
	public String toString() {
		String ClassNameAndFieldValue;
		ClassNameAndFieldValue = "sub" + "\n" + " Class name: " + this.getClass().getSimpleName() + "\n" + " stroka1 = " + this.getStroka1() + "\n" + " stroka2 = " + this.stroka2;
		return ClassNameAndFieldValue;
	}
}

public class example16_01 {
	public static void main( String[] args ) {
		qwe_01_01 superClassObject = new qwe_01_01("передал в конструктор суперкласса");
		String className = superClassObject.toString();
		System.out.println( className );
		
		qwe_01_02 subClassObject1 = new qwe_01_02("передал в конструктор подкласса");
		String subClassName1 = subClassObject1.toString();
		System.out.println( subClassName1 );

		qwe_01_02 subClassObject2 = new qwe_01_02("передал в конструктор подкласса", "где два параметра");
		String subClassName2 = subClassObject2.toString();
		System.out.println( subClassName2 );
	}
}