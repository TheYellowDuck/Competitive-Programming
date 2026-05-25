package Y2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_Super_Plumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		while (N != 0) {
			int[][] A = new int[N][M];
			for (int i = 0; i < N; i ++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < M; j ++) {
					switch (ch[j]) {
					case '*':
						A[i][j] = -1;
						break;
					case '.':
						break;
					default:
						A[i][j] = ch[j] - '0';
					}
					if (i != 0 && A[i][j] != -1 && A[i - 1][j] != -1)
							A[i][j] += A[i - 1][j];
				}
			}
			
		}
		
	}

}
