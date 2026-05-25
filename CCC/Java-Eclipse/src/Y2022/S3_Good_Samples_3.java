package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_Good_Samples_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		long K = Long.parseLong(in[2]);
		int[] P = new int[N];
		for (int i = 0; i < N; i ++) {
			int rem = N - i - 1;
			long cur = Math.min(K - rem, M);
			if (cur <= 0) break;
			int val;
			if (cur > i) {
				val = Math.min(M, i + 1);
				cur = val;
			}
			else val = P[(int) (i - cur)];
			P[i] = val;
			K -= cur;
		}
		if (K != 0)
			System.out.print(-1);
		else
			for (int i : P)
				System.out.print(i + " ");
		System.out.println();
	}
	
}
