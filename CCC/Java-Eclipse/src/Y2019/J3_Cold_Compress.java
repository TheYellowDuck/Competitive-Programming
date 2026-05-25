package Y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J3_Cold_Compress {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N > 0) {
			char[] in = br.readLine().toCharArray();
			int c = 1;
			for (int i = 1; i < in.length; i++) {
				if (in[i] != in[i - 1]) {
					System.out.print(c + " " + in[i - 1] + " ");
					c = 0;
				}
				c++;
			}
			System.out.println(c + " " + in[in.length - 1]);
			N--;
		}

	}

}
