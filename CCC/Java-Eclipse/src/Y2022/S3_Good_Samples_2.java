package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_Good_Samples_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		long K = Long.parseLong(in[2]);
		int[] P = new int[N];
		for (int i = 0; i < N; i ++) {
			int rem = N - i - 1;                           //remainder of values needed to be calculated - current value
			int cur = (int) Math.min(K - rem, M);          //current number of good samples needed/able to be calculated
			if (cur <= 0) break;
			int val;                                       //value of note
			if (cur > i) {
				val = Math.min(M, i + 1);                  //check if value is less than M (1, 2, 3, 4)
				cur = val;
			}
			else val = P[i - cur];                         //set val as the value cur spaces back to give cur good samples
			P[i] = val;
			K -= cur;
		}
		if (K != 0) System.out.println(-1);
		else {
			for (int i : P)
				System.out.print(i + " ");
		}
	}

}
