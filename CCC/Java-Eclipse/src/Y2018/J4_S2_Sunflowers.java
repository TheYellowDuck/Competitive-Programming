package Y2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J4_S2_Sunflowers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int [N][N];
		boolean H = true, Y = true;
		for (int i = 0; i < N; i ++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++) {
				A[i][j] = Integer.parseInt(in.nextToken());
				if (j != 0 && A[i][j] < A[i][j - 1]) H = false;
				if (i != 0 && A[i][j] < A[i - 1][j]) Y = false;
			}
		}
		if (H) {
			if (Y) {
				for (int[] i : A) {
					for (int j : i) 
						System.out.print(j + " ");
					System.out.println();
				}
			}
			else {
				for (int i = 0; i < N; i ++) {
					for (int j = N - 1; j >= 0; j --)
						System.out.print(A[j][i] + " ");
					System.out.println();
				}
			}
		}
		else {
			if (Y) {
				for (int i = N - 1; i >= 0; i --) {
					for (int j = 0; j < N; j ++)
						System.out.print(A[j][i] + " ");
					System.out.println();
				}
			}
			else {
				for (int i = N - 1; i >= 0; i --) {
					for (int j = N - 1; j >= 0; j --)
						System.out.print(A[i][j] + " ");
					System.out.println();
				}
			}
		}

	}

}
