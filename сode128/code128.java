/*
Про code128: https://courses.cs.washington.edu/courses/cse370/01au/minirproject/BarcodeBattlers/barcodes.html
*/
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class code128 {
	final static String[] typeA = new String[] {
		" ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",", "-", ".", "/",
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "\\]", "SPACE", "_", "NUL", "SOH",
		"STX" ,"ETX", "EOT", "ENQ", "ACK", "BEL", "BS", "HT", "LF", "VT", "FF", "CR", "SO",
		"SI", "DLE", "DC1", "DC2", "DC3", "DC4", "NAK", "SYN", "ETB", "CAN", "EM", "SUB",
		"ESC", "FS", "GS", "RS", "US", "FNC3", "FNC2", "SHIFT", "Code C", "Code B", "FNC4",
		"FNC1", "START A", "START B", "START C"
	};
	final static String[] typeB = new String[] {
		" ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",", "-", ".", "/",
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "\\]", "SPACE", "_", "`", "a",
		"b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
		"s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~", "DEL", "FNC3", "FNC2",
		"SHIFT", "Code C", "FNC4", "Code A", "FNC1", "START A", "START B", "START C"
	};
	final static String[] typeC = new String[] {
		"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
		"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
		"32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
		"48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63",
		"64", "65", "66", "67" ,"68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79",
		"80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95",
		"96", "97", "98", "99", "Code B", "Code A", "FNC1", "START A", "START B", "START C"
	};
	final static String[] encoding = new String[] {
		"11011001100", "11001101100", "11001100110", "10010011000", "10010001100", "10001001100", "10011001000",
		"10011000100", "10001100100", "11001001000", "11001000100", "11000100100", "10110011100", "10011011100",
		"10011001110", "10111001100", "10011101100", "10011100110", "11001110010", "11001011100", "11001001110",
		"11011100100", "11001110100", "11101101110", "11101001100", "11100101100", "11100100110", "11101100100",
		"11100110100", "11100110010", "11011011000", "11011000110", "11000110110", "10100011000", "10001011000",
		"10001000110", "10110001000", "10001101000", "10001100010", "11010001000", "11000101000", "11000100010",
		"10110111000", "10110001110", "10001101110", "10111011000", "10111000110", "10001110110", "11101110110",
		"11010001110", "11000101110", "11011101000", "11011100010", "11011101110", "11101011000", "11101000110",
		"11100010110", "11101101000", "11101100010", "11100011010", "11101111010", "11001000010", "11110001010",
		"10100110000", "10100001100", "10010110000", "10010000110", "10000101100", "10000100110", "10110010000",
		"10110000100", "10011010000", "10011000010", "10000110100", "10000110010", "11000010010", "11001010000",
		"11110111010", "11000010100", "10001111010", "10100111100", "10010111100", "10010011110", "10111100100",
		"10011110100", "10011110010", "11110100100", "11110010100", "11110010010", "11011011110", "11011110110",
		"11110110110", "10101111000", "10100011110", "10001011110", "10111101000", "10111100010", "11110101000",
		"11110100010", "10111011110", "10111101110", "11101011110", "11110101110", "11010000100", "11010010000",
		"22010011100"
	};
	final static String stopcode = "1100011101011";
	final static int lengthtable = encoding.length;
	
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.print( "Input a text: " );
		String text = in.nextLine();
		try {
			File outputfile = new File( "barcode.png" );
			ImageIO.write( getBarcode( genCode( text, 'b' ), 1 ), "png", outputfile );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static String genCode( String input, char type ) {
		String code = "";
		int checksum = 0;
		if ( type == 'a' ) {
			code += encoding[103];
		}
		if ( type == 'b' ) {
			code += encoding[104];
		}
		if ( type == 'c' ) {
			code += encoding[105];
		}
		for ( int i = 0; i < input.length(); i++ ) {
			String symbol = Character.toString( input.charAt( i ));
			for ( int i2 = 0; i2 < lengthtable; i2++ ) {
				String symbolarray = "";
				if ( type == 'a' ) {
					symbolarray = typeA[i2];
				}
				if ( type == 'b' ) {
					symbolarray = typeB[i2];
				}
				if ( type == 'c' ) {
					symbolarray = typeC[i2];
				}
				if ( symbol.equals( symbolarray ) == true ) {
					code += encoding[i2];
					checksum += ( i2 * ( i + 1 ));
				}
			}
		}
		code += encoding[( checksum % 103 ) + 1];
		code += stopcode;
		return code;
	}
	
	public static BufferedImage getBarcode( String bincode, int size ) {
		int width = bincode.length() * size;
		int height = 32 * size;
		BufferedImage image = new BufferedImage( width, height,  BufferedImage.TYPE_INT_RGB );
		Graphics g = image.createGraphics();
		g.setColor( new Color( 255, 255, 255 ));
		g.fillRect( 0, 0, width, height );
		g.setColor( new Color( 0, 0, 0 ));
		for ( int i = 0; i < bincode.length(); i++ ) {
			if ( bincode.charAt( i ) == '1' ) {
				for ( int i2 = 0; i2 < size; i2++ ) {
					g.drawLine(( i * size ) + i2, 0, ( i * size ) + i2, height );
				}
			}
		}
		return image;
	}
}