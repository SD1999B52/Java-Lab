/*
Индиана Джонс, 1981, США, приключения, стоимость проката
Брат, 1997, Россия, драма, стоимость проката
Крепкий орешек, 1988, США, боевик, стоимость проката
Криминальное чтиво, 1994, США, криминальный фильм, стоимость проката
Охота на пиранью, 2006, Россия, боевик, стоимость проката
*/

import java.io.RandomAccessFile;
import java.io.File;
import java.util.Scanner;

class ex_3_1 {
	public static void main( String[] args ) {
		try {
			//создаем исходный файл
			File sourceFile = new File( "file_1.txt" );
			sourceFile.createNewFile();
			
			RandomAccessFile source = new RandomAccessFile( sourceFile, "rw" );
			
			Scanner in = new Scanner( System.in );
			System.out.print( "Введите количество фильмов: " );
			int numFilms = in.nextInt();
			in.nextLine();
			
			System.out.println( "Введите информацию о фильмах( название_фильма, год_выпуска, страна, жанр, стоимость_проката ):" );
			for ( int i = 0; i < numFilms; i++ ) {
				String line = in.nextLine();
				source.writeUTF( line + "\n" );
			}
			
			//перемещаем каретку в начало файла
			source.seek( 0 );
			
			//создаем второй файл
			File anotherFile = new File( "file_2.txt" );
			anotherFile.createNewFile();
			
			RandomAccessFile another = new RandomAccessFile( anotherFile, "rw" );
			
			for ( int i = 0; i < numFilms; i++ ) {
				String line = source.readUTF();
				
				String[] data = line.split( ", " );
				if ( data[2].equals( "Россия" ) == true ) {
					another.writeUTF( line );
				}
			}
			
			another.close();
			source.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}