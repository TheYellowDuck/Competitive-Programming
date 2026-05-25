package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class THICC_17_P5_Smarties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> mp = new HashMap<>();
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]), l = 0, r = 0, k = 0;
		long c = 0;
		int[] A = new int[N];
		in = br.readLine().split(" ");
		
		for (l = 0; l < N; l ++) {
			while (k < K && r < N) {
				int v = Integer.parseInt(in[r]);
				A[r] = v;
				mp.put(v, mp.getOrDefault(v, 0) + 1);
				if (mp.get(v) == 1)
					k ++;
				r ++;
			}
			if (k < K)
				break;
			c += N - r + 1;
			mp.put(A[l], mp.get(A[l]) - 1);
			if (mp.get(A[l]) == 0)
				k --;
		}
		
		System.out.println(c);

	}

}
