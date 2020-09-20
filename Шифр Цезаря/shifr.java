import java.util.Scanner;
public class shifr {
	static char[] alfavit = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
							  'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
							  'A', 'B', 'C', 'D', 'C', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
							  'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
							  'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
							  'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
							  'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 
							  'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 
							  'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю',
							  'Я'};
	static char[] shifralfavit = new  char[ alfavit.length ];
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.print("Введите текст: ");
		String text = in.nextLine();
		System.out.printf("Введите ключ ( от 0 до %s ): ", alfavit.length );
		int key = in.nextInt();
		System.out.print("1 - зашифровать, 2 - расшифровать: ");
		int mod = in.nextInt();
		if ( key < alfavit.length ) {
			shifrcreate( key ); //создаем новый алфавит
			if ( mod == 1 ) System.out.print( "За" ); else System.out.print( "Рас" );
			System.out.print( "шифрованный текст: " + shifrrashifr( text, mod ) + "\n");
		} else {
			System.out.print("Ключ не может быть больше количества симвалов в алфавите");
		}
		in.close();
	}
	public static void shifrcreate( int key ) {
		for ( int i = 0; i < alfavit.length; i++ ) {
			if ( i + key < alfavit.length ) {
				shifralfavit[i] = alfavit[i + key];
			} else {
				shifralfavit[i] = alfavit[( alfavit.length - ( i + key )) * -1 ];
			}
		}
	}
	public static String shifrrashifr( String text, int mod ) {
		int i2;
		boolean est = false;
		String newtext = "";
		for ( int i = 0; i < text.length(); i++ ) {
			char simbol = text.charAt( i ); //получаем символ из строки
			for ( i2 = 0; i2 < alfavit.length; i2++ ) {
				if ( mod == 1 ) {
					if ( alfavit[i2] == simbol ) {
						newtext = newtext + shifralfavit[i2];
						break; //выход из цикла
					}
				} else {
					if ( shifralfavit[i2] == simbol ) {
						newtext = newtext + alfavit[i2];
						break; //выход из цикла
					}
				}
			}		
		}
		return newtext;
	}
}
