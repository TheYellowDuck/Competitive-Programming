package Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MWC_15_2_P5_Watchmeblink1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine()), T = Integer.parseInt(br.readLine());
		long[] pda = new long[3 * N + 1];
		int[] wow = new int[3];
		
		while (T -- > 0) {
			
			String[] in = br.readLine().split(" ");
			int v = Integer.parseInt(in[2]), p = Integer.parseInt(in[3]) - 1;
			
			pda[p * N + Integer.parseInt(in[0]) - 1] += v;
			pda[p * N + Integer.parseInt(in[1])] -= v;
			
		}
		
		if (pda[0] < K)
			wow[0] ++;
		for (int i = 1; i < N * 3; i ++) {
			pda[i] += pda[i - 1];
			if (pda[i] < K)
				wow[i / N] ++;
		}
		
		for (int i : wow)
			System.out.println(i);

	}

}
