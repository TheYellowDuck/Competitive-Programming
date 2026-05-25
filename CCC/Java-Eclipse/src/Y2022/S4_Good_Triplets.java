package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_Good_Triplets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), C = Integer.parseInt(in[1]);
		double oppo = (double) C / 2;
		int[] P = new int[C];
		in = br.readLine().split(" ");
		for (String i : in) 
			P[Integer.parseInt(i)] ++;
		for (int i : P)
			System.out.print(i + " ");
		System.out.println();
		long count = 0;
		for (int a = 0; a < oppo; a ++) 
			for (int b = a + 1; b < a + oppo; b ++) 
				for (int c = (int) (a + oppo) + 1; c < (b + oppo) && c < C; c ++) {
					count += ((long)P[a] * P[b] * P[c]);
					System.out.println("P[" + a + "] = " + P[a] + " " + "P[" + b + "] = " + P[b] + " " + "P[" + c + "] = " + P[c] + " " + count);
				}
		System.out.println(count);
	}

}
