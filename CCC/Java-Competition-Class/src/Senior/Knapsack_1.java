package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int I = Integer.parseInt(in[0]), W = Integer.parseInt(in[1]), w, v;
		long[] ans = new long[W + 1];
		for (; I > 0; I--) {
			in = input.readLine().split(" ");
			w = Integer.parseInt(in[0]);
			v = Integer.parseInt(in[1]);
			for (int i = W - w; i >= 0; i--) {
				ans[i + w] = Math.max(ans[i + w], ans[i] + v);
			}

		}
		long mv = 0;
		for (long i : ans) {
			mv = Math.max(mv, i);
		}
		System.out.println(mv);

	}

}
