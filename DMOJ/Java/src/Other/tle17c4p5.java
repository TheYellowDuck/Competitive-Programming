package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tle17c4p5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		int[] A = new int[(N + 1) / 2];
		A[0] = 1;
		int a = N, b = 1;
		System.out.println(1 % M);
		for (int i = 1; i < A.length; i ++) {
			A[i] = A[i - 1] * a -- / b ++;
			System.out.println(A[i] % M);
		}
		if (N % 2 == 0) {
			System.out.println((A[A.length - 1] * a -- / b ++) % M);
		}
		for (int i = A.length - 1; i >= 0; i --) {
			System.out.println(A[i] % M);
		}

	}

}
