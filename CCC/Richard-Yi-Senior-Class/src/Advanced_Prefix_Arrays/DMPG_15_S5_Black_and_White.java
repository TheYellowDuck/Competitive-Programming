package Advanced_Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMPG_15_S5_Black_and_White {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		boolean[][] A = new boolean[N + 1][N + 1];
		
		while (M -- > 0) {
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]), w = Integer.parseInt(in[2]), h = Integer.parseInt(in[3]);
			A[x][y] = !A[x][y];
			A[x + w][y] = !A[x + w][y];
			A[x][y + h] = !A[x][y + h];
			A[x + w][y + h] = !A[x + w][y + h];
		}
		
		M = 0;
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				A[i][j] = (i == 0 ? false : A[i - 1][j]) ^ (j == 0 ? false : A[i][j - 1]) ^ (i == 0 || j == 0 ? false : A[i - 1][j - 1]) ^ A[i][j];
				if (A[i][j]) 
					M ++;
			}
		}
		System.out.println(M);
	}

}
