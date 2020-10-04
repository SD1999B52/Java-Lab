import java.util.Scanner;
public class example16_08 {
	static char[] alfavit = new char[ 26 * 2 ]; //Так как заглавные и строчные
	static char[] shifralfavit = new  char[ alfavit.length ];
	public static void main( String[] args ) {
		//заполняем массив алфавита с помощью кодовой таблицы
		int a = 0; //смещение
		for ( int i = 0; i < 52; i++ ) {
			if ( i >= 26 ) a = 6;
			alfavit[i] = (char)( i + 65 + a );
		}
		Scanner in = new Scanner( System.in );
		System.out.print("Введите текст для шифрования: ");
		String text = in.nextLine();
		System.out.printf("Введите ключ: " );
		int key = in.nextInt();
		shifrcreate( key ); //создаем новый алфавит
		String textpre = shifrrashifr( text, 1 );
		System.out.print( "Текст после преобразования: " + textpre + "\n" );
		in.nextLine(); // так как проскакивала из-за перехода на новую строку
		System.out.print( "Выполнить обратное преобразование? (y/n): " );
		while ( 1 < 2 ) {
			String mod = in.nextLine();
			if ( mod.equals( "y" )) {
				System.out.print( "Расшифрованный текст: " + shifrrashifr( textpre, 2 ) + "\n" );
				break;
			} 
			if ( mod.equals( "n" )) {
				System.out.print( "До свидания!\n" );
				break;
			}
			System.out.print( "Введите корректный ответ: " );
		}
		in.close();
	}
	public static void shifrcreate( int key ) {
		for ( int i = 0; i < alfavit.length; i++ ) {
			//Изменено на вариант со сдвигом по кругу в лево при + и в право при -
			int jk = ( key + i ) % alfavit.length;
			if ( jk < 0 ) {
				shifralfavit[i] = alfavit[ jk + alfavit.length ]; //в право при - 
			} else {
				shifralfavit[i] = alfavit[ jk ]; //в лево при +
			}
		}
		/*
		//Для проверки правильности сдвига
		for ( int i = 0; i < alfavit.length; i++ ) {
			System.out.print( shifralfavit[i] + " " );
		}
		*/
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
