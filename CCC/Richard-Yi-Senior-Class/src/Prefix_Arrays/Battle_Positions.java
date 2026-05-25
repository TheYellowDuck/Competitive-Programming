package Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle_Positions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine()), W = Integer.parseInt(br.readLine());
		int[] pda = new int[S + 1];
		
		while (W-- > 0) {
			String[] in = br.readLine().split(" ");
			int v = Integer.parseInt(in[2]);
			pda[Integer.parseInt(in[0]) - 1] += v;
			pda[Integer.parseInt(in[1])] -= v;
		}
		int count = 0;
		if (pda[0] < N) 
			count++;
		for(int i = 1; i < S; i++) {
			pda[i] += pda[i - 1];
			if (pda[i] < N)
				count++;
		}
		System.out.println(count);
		
	}

}
