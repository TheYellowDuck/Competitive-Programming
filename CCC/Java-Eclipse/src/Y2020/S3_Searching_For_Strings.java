package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_Searching_For_Strings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int[] c = new int[26];
		char[] c1 = input.readLine().toCharArray();
		String s = input.readLine();
		for (char i : c1) c[i - 'a']++;
		for (int i = c1.length - 1; i < s.length(); i++) {
			
		}

	}

}
