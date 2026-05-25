package Advanced_Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMOPC_15_Contest_1_P5_Lelei_and_Dragon_Scales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int W = Integer.parseInt(in[0]) + 1, H = Integer.parseInt(in[1]) + 1, N = Integer.parseInt(in[2]), M = 0;
		int[][] A = new int[H][W];
		
		for (int i = 1; i < H; i ++) {
			in = br.readLine().split(" ");
			for (int j = 1; j < W; j ++) {
				A[i][j] = A[i - 1][j] + A[i][j - 1] - A[i - 1][j - 1] + Integer.parseInt(in[j - 1]);
				for (int w = j; w > 0; w --) {
					int h = N / w;
					if (h > i)
						continue;
					M = Math.max(M, A[i][j] - A[i - h][j] - A[i][j - w] + A[i - h][j - w]);
				}
			}
		}
		
		System.out.println(M);

	}

}
