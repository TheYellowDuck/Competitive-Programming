package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Attack_of_the_CipherTexts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Character> map=new HashMap<Character, Character>();
		char[] plain=input.readLine().toCharArray();
		char[] cipher=input.readLine().toCharArray();
		for (int i=0; i<plain.length; i++) {
			map.put(cipher[i], plain[i]);
		}
		cipher=input.readLine().toCharArray();
		plain=new char[cipher.length];
		for (int i=0; i<cipher.length; i++) {
			try {
				plain[i]=map.get(cipher[i]);
			}
			catch (NullPointerException npe) {
				plain[i]='.';
			}
		}
		System.out.println(String.valueOf(plain));
	}

}
