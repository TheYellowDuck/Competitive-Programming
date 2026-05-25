package Y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J4_Flipper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray();
		boolean h = false, v = false;
		for (char i : in) {
			if (i == 'H') h = !h;
			else v = !v;
		}
		if (!h && !v) 
			System.out.println("1 2\n3 4");
		else if (h && !v) 
			System.out.println("3 4\n1 2");
		else if (!h && v)
			System.out.println("2 1\n4 3");
		else
			System.out.println("4 3\n2 1");
	}

}
