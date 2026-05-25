package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMOPC_18_Contest_5_P3_A_Familiar_Problem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), l = 0, r = 0, max = 0;
		long M = Long.parseLong(in[1]), s;
		in = br.readLine().split(" ");
		int[] A = new int[N];
		for (int i = 0; i < N; i ++) 
			A[i] = Integer.parseInt(in[i]);
		s = A[0];
		while (r < N || s >= M) {
			if (s >= M) {
				max = Math.max(max, r - l);
				s -= A[l];
				l ++;
				if (l > r && l < N) {
					r = l;
					s += A[r];
				}
			}
			else {
				r ++;
				if (r < N)
					s += A[r];
			}
		}
		System.out.println(Math.max(max, r - l));

	}

}
