package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mimi_and_Substrings {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char[] in = input.readLine().toCharArray();
		int l = Integer.parseInt(input.readLine()) - 1, len = in.length, com = in[0], v, c = 1;
		int[] a = new int[len];
		for (int i = 1; i < len; i++) {
			v = in[i];
			if (v == com)
				c++;
			else {
				a[i - 1] = c;
				com = in[i];
				c = 1;
			}
		}
		a[len - 1] = c;
		c = 0;
		for (int i : a)
			if (i > l)
				c += i - l;
		System.out.println(c);

	}

}
