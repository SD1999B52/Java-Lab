/*
Индиана Джонс, 1981, США, приключения, стоимость проката
Брат, 1997, Россия, драма, стоимость проката
Крепкий орешек, 1988, США, боевик, стоимость проката
Криминальное чтиво, 1994, США, криминальный фильм, стоимость проката
Охота на пиранью, 2006, Россия, боевик, стоимость проката
*/


import java.util.Scanner;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Film implements Serializable {
	String name, year, country, genre, rental_cost;
}

class ex_3_2 {
	public static void main( String[] args ) {
		try {
			/*------------------------------
			Запись фильмов в исходный файл
			------------------------------*/
			
			//создаем исходный файл
			File sourceFile = new File( "file_1.txt" );
			sourceFile.createNewFile();
			
			//поток для записи объекта
			FileOutputStream fosSourceFile = new FileOutputStream( sourceFile );
			ObjectOutputStream oosSourceFile = new ObjectOutputStream( fosSourceFile );
		
			Scanner in = new Scanner( System.in );
			System.out.print( "Введите количество фильмов: " );
			int numFilms = in.nextInt();
			in.nextLine();
			
			System.out.println( "Введите информацию о фильмах( название_фильма, год_выпуска, страна, жанр, стоимость_проката ):" );
			for ( int i = 0; i < numFilms; i++ ) {
				String line = in.nextLine();
				String[] data = line.split( ", " );
				
				Film film = new Film();
				film.name = data[0];
				film.year = data[1];
				film.country = data[2];
				film.genre = data[3];
				film.rental_cost = data[4];
				
				//запись в файл
				oosSourceFile.writeObject( film );
			}
			
			oosSourceFile.flush();
			oosSourceFile.close();

			/*---------------------------------------------
			Чтение фильмов, выборка и запись во второй файл
			---------------------------------------------*/
			
			//поток для чтения объекта
			FileInputStream fisSourceFile = new FileInputStream( sourceFile );
			ObjectInputStream oisSourceFile = new ObjectInputStream( fisSourceFile );
			
			//создаем второй файл
			File anotherFile = new File( "file_2.txt" );
			anotherFile.createNewFile();
			
			//поток для записи объекта
			FileOutputStream fosAnotherFile = new FileOutputStream( anotherFile );
			ObjectOutputStream oosAnotherFile = new ObjectOutputStream( fosAnotherFile );
			
			for ( int i = 0; i < numFilms; i++ ) {
				Film film = new Film();
				film = (Film)oisSourceFile.readObject();
				
				if ( film.country.equals( "Россия" ) == true ) {
					oosAnotherFile.writeObject( film );
				}
			}
			
			oosAnotherFile.flush();
			oosAnotherFile.close();
			
			oisSourceFile.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}