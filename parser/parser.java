/*
под ELTEX NTP-RG-1402G-W:rev.C
отправка запросов, получение и отправка Cookie, получение HTML страницы
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.CookieManager;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.util.List;
import java.util.ArrayList;

class parser {
	public static void main( String[] args ) {
		try {
			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault( cookieManager );
			
			//авторизуемся и получаем Cookie
			URL address = new URL( "http://192.168.1.1/login" );
			HttpURLConnection connection = ( HttpURLConnection )address.openConnection();
			connection.setDoOutput( true );
			connection.setRequestMethod( "GET" );
			
			OutputStream query = connection.getOutputStream();
			String params = "username=admin&password=kW5i_1bYC6os";
			query.write( params.getBytes( "UTF-8" ));
			String cookie = connection.getHeaderField( "Set-Cookie" );
			
			//получаем код страницы
			address = new URL( "http://192.168.1.1/dhcpinfo.html" );
			connection = ( HttpURLConnection )address.openConnection();
			connection.setRequestProperty( "Cookie", cookie );
			outTable( delHtml( getSheet( connection )));
			
			connection.disconnect();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void outTable( ArrayList<String> value ) {
		String[][] array = new String[value.size() + 1][4];
		System.out.println( "Device Info / DHCP" );
		for ( int i = 0; i < value.size(); i++ ) {
			String line = value.get( i );
			String text = "";
			int col = 0;
			for ( int i2 = 0; i2 < line.length(); i2++ ) {
				if (( line.charAt( i2 ) != '|' ) & ( i2 != line.length() - 1 )) {
					text += line.charAt( i2 );
				} else {
					array[i + 1][col] = text;
					col += 1;
					text = "";
					continue;
				}
			}
		}
		
		array[0][0] = "Hostname";
		array[0][1] = "MAC Address";
		array[0][2] = "IP Address";
		array[0][3] = "Expires In";
		
		int[] colsize = new int[array[0].length];
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				if ( colsize[i2] < array[i][i2].length()) {
					colsize[i2] = array[i][i2].length();
				}
			}
		}
		
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				System.out.print( array[i][i2] );
				for ( int i3 = array[i][i2].length(); i3 < colsize[i2]; i3++ ) {
					System.out.print( " " );
				}
				System.out.print( " | " );
			}
			System.out.println();
		}
	}
	
	public static ArrayList<String> delHtml( String value ) {
		ArrayList<String> lines = new ArrayList<String>();
		boolean found = false;
		int i = 0;
		String line = "";
		while ( 1 < 2 ) {
			String teg = value.substring( i, i + 9 );
			if ( teg.equals( " <tr><td>" ) == true ) {
				i += 9;
				found = true;
			}
			
			teg = value.substring( i, i + 19 );
			if ( teg.equals( "</td></tr> <tr><td>" ) == true ) {
				lines.add( line );
				line = "";
				i += 19;
			}
			
			teg = value.substring( i, i + 9 );
			if ( teg.equals( "</td><td>" ) == true ) {
				line += "|";
				i += 9;
			}
			
			teg = value.substring( i, i + 10 );
			if ( teg.equals( "</td></tr>" ) == true ) {
				lines.add( line );
				break;
			}
			
			if ( found == true ) {
				line += value.charAt( i );
			}
			i += 1;
		}
		return lines;
	}
	
	public static String getSheet( HttpURLConnection value ) {
		String sheet = "";
		try {
			BufferedReader sheetbuffer = new BufferedReader( new InputStreamReader( value.getInputStream()));
			boolean exit = false;
			while ( exit == false ) {
				String line = sheetbuffer.readLine();
				for ( int i = 0; i < line.length(); i++ ) {
					if ( i + 7 <= line.length()) {
						String text = line.substring( i, i + 7 );
						if ( text.equals( "</html>" ) == true ) {
							exit = true;
						}
					}
				}
				sheet += line;
			}
			sheetbuffer.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public static void outCookies( CookieManager value ) {
		List<HttpCookie> cookies = value.getCookieStore().getCookies();
		for ( int i = 0; i < cookies.size(); i++ ) {
			System.out.println( cookies.get( i ).getDomain());
			System.out.println( cookies.get( i ));
		}
	}
}