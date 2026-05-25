package Sorting_Stacks_and_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class City_Game {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T -- > 0) {
			String[] in = br.readLine().split(" ");
			int M = Integer.parseInt(in[0]), N = Integer.parseInt(in[1]), max = 0;
			int[] L = new int[N], R = new int[N], H = new int[N];
//			Arrays.fill(R, N - 1);
			
			for (int i = 0; i < M; i ++) {
				in = br.readLine().split(" ");
				int index = 0;
//				L[0] = -1;
				for (int j = 0; j < N; j ++) {
					if (in[j].contentEquals("F")) {
						if (H[index] >= H[j]) {
							L[j] = index;
							if (H[index] != H[j])
								index = j;
						}
						else 
							L[j] = j;
					}
					else {
						index = j + 1;
						H[j] = 0;
					}
				}
				index = N - 1;
//				R[N - 1] = N;
				for (int j = N - 1; j >= 0; j --) {
					if (in[j].contentEquals("F")) {
						H[j] ++;
						if (H[index] >= H[j]) {
							R[j] = index;
							if (H[index] != H[j])
								index = j;
						}
						else 
							R[j] = j;
						max = Math.max(max, H[j] * (R[j] - L[j] + 1));
					}
					else {
						index = j - 1;
						H[j] = 0;
					}
				}
			}
			System.out.println(max * 3);
			if (T != 0)
				br.readLine();
		}

	}

}
