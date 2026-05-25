package Y2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_Factor_Solitaire {
	
	static int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		A[1] = 0;
		System.out.println(recurse(N));
	}
	
	static int recurse(int N) {
		if (N == 1)
			return 0;
		if (A[N] != 0)
			return A[N];
		int min = Integer.MAX_VALUE;
		for (int i = N / 2; i >= 1; i --) {
			if ((N - i) % i != 0)
				continue;
			int v = recurse(N - i) + ((N - i) / i);
			min = Math.min(min, v);
			break;
		}
		A[N] = min;
		return min;
	}

}
