package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class S3_Good_Samples {
	
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		N = Integer.parseInt(in[0]); M = Integer.parseInt(in[1]); K = Integer.parseInt(in[2]);
		int[] A = recurse(new int[N], 0, 0);
		if (A == null)
			System.out.println(-1);
		else {
			for (int i : A) 
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	static int[] recurse(int[] A, int i, int k) {
		for (int x = i - 1; x >= 0; x --) {
			HashSet<Integer> set = new HashSet<>();
			for (int y = x; y < i; y ++) 
				set.add(A[y]);
			if (set.size() == i - x)
				k ++;
		}
		if (k > K)
			return null;
		if (i == N) {
			System.out.println(Arrays.toString(A));
			if (k == K)
				return A;
			else return null;
		}
		int[] a = A.clone();
		int[] r = null;
		for (int j = 1; j <= M; j ++) {
			a[i] = j;
			r = recurse(a, i + 1, k);
			if (r != null)
				return r;
		}
		return null;
	}

}
