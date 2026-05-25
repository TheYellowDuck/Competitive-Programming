package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Morse_Code {
	public static final HashMap<String, String> code=new HashMap<String, String>() {{
		put("A", ".-");
		put("B", "-...");
		put("C", "-.-.");
		put("D", "-..");
		put("E", ".");
		put("F", "..-.");
		put("G", "--.");
		put("H", "....");
		put("I", "..");
		put("J", ".---");
		put("K", "-.-");
		put("L", ".-..");
		put("M", "--");
		put("N", "-.");
		put("O", "---");
		put("P", ".--.");
		put("Q", "--.-");
		put("R", ".-.");
		put("S", "...");
		put("T", "-");
		put("U", "..-");
		put("V", "...-");
		put("W", ".--");
		put("X", "-..-");
		put("Y", "-.--");
		put("Z", "--..");
		put("0", "-----");
		put("1", ".----");
		put("2", "..---");
		put("3", "...--");
		put("4", "....-");
		put("5", ".....");
		put("6", "-....");
		put("7", "--...");
		put("8", "---..");
		put("9", "----.");
		put("ä", ".-.-");
		put("á", ".--.-");
		put("å", ".--.-");
		put("é", "..-..");
		put("ñ", "--.--");
		put("ö", "---.");
		put("ü", "..--");
		put("&", ".-...");
		put("'", ".----.");
		put("@", ".--.-.");
		put(")", "-.--.-");
		put("(", "-.--.");
		put(":", "---...");
		put(",", "--..--");
		put("=", "-...-");
		put("!", "-.-.--");
		put(".", ".-.-.-");
		put("-", "-....-");
		put("+", ".-.-.");
		put("\"", ".-..-.");
		put("?", "..--..");
		put("/", "-..-.");
	}}, string=new HashMap<String, String>() {{
		put(".-", "A");
		put("-...", "B");
		put("-.-.", "C");
		put("-..", "D");
		put(".", "E");
		put("..-.", "F");
		put("--.", "G");
		put("....", "H");
		put("..", "I");
		put(".---", "J");
		put("-.-", "K");
		put(".-..", "L");
		put("--", "M");
		put("-.", "N");
		put("---", "O");
		put(".--.", "P");
		put("--.-", "Q");
		put(".-.", "R");
		put("...", "S");
		put("-", "T");
		put("..-", "U");
		put("...-", "V");
		put(".--", "W");
		put("-..-", "X");
		put("-.--", "Y");
		put("--..", "Z");
		put("-----", "0");
		put(".----", "1");
		put("..---", "2");
		put("...--", "3");
		put("....-", "4");
		put(".....", "5");
		put("-....", "6");
		put("--...", "7");
		put("---..", "8");
		put("----.", "9");
		put(".-.-", "ä");
		put(".--.-", "á");
		put(".--.-", "å");
		put("..-..", "é");
		put("--.--", "ñ");
		put("---.", "ö");
		put("..--", "ü");
		put(".-...", "&");
		put(".----.", "'");
		put(".--.-.", "@");
		put("-.--.-", ")");
		put("-.--.", "(");
		put("---...", ":");
		put("--..--", ",");
		put("-...-", "=");
		put("-.-.--", "!");
		put(".-.-.-", ".");
		put("-....-", "-");
		put(".-.-.", "+");
		put(".-..-.", "\"");
		put("..--..", "?");
		put("-..-.", "/");
		put("........", "<MISTAKE>");
		put("MTS", "\b");
	}}, phrases=new HashMap<String, String>() {{
		put("AA", "\r\n");
		put("AR", "<END OF MESSAGE>");
		put("AS", "<WAIT>");
		put("BK", "<BREAK>");
		put("BT", "\r\n\r\n    ");
		put("CL", "<CLEAR>");
		put("CT", "<START COPYING>");
		put("DO", "<SWITCH TO WABUN CODE>");
		put("KN", "<INVITE SPECIFIC STATION>");
		put("SK", "<END OF TRANSMISSION>");
		put("SN", "<UNDERSTOOD>");
		put("VE", "<UNDERSTOOD>");
		put("SOS", "<DISTRESS MESSAGE>");
		put("K", "<OVER>");
		put("R", "<ROGER>");
		put("CUL", "<SEE YOU LATER>");
		put("BCNU", "<BE SEEING YOU>");
		put("UR", "<YOU'RE>");
		put("RST", "<SIGNAL REPORT>");
		put("73", "<BEST REGARDS>");
		put("88", "<LOVE AND KISSES>");
		put("QSL", "<I ACKNOWLEDGE RECEIPT>");
		put("QSL?", "<DO YOU ACKNOWLEDGE?>");
		put("QRX", "<WAIT>");
		put("QRX?", "<SHOULD I WAIT?>");
		put("QRV", "<I AM READY TO COPY>");
		put("QRV?", "<ARE YOU READY TO COPY?>");
		put("QRL", "<FREQUENCY IN USE>");
		put("QRL?", "<IS FREQUENCY IN USE?>");
		put("QTH", "<MY LOCATION IS>");
		put("QTH?", "<WHAT IS YOUR LOCATION?>");
	}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] in=input.readLine().split("[#| ]");
			if (in[0].indexOf("MTS")==0) {
				String[] out=new String[in.length-1];
				Arrays.fill(out, "");
				for (int i=1; i<in.length; i++) {
					String c=string.get(in[i]);
					if (c==null) out[i-1]=out[i-1].concat("#");
					else out[i-1]=out[i-1].concat(c);
				}
				System.out.println(String.join(" ", out));
			}
			else if (in[0].indexOf("STM")==0) {
				
			}
		}
	}

}
