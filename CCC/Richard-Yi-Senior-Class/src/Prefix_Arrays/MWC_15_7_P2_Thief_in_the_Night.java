package Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MWC_15_7_P2_Thief_in_the_Night {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int F = Integer.parseInt(in[0]), R = Integer.parseInt(in[1]);
		int[] psa = new int[F * R + 1];
		
		for (int i = 0; i < F; i++) {
			in = br.readLine().split(" ");
			
			for (int j = 0; j < in.length; j++) 
				psa[i * R + j + 1] = psa[i * R + j] + Integer.parseInt(in[j]);
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		while (Q-- > 0) {
			in = br.readLine().split(" ");
			int f = Integer.parseInt(in[2]) - 1;
			System.out.println(psa[f * R + Integer.parseInt(in[1])] - psa[f * R + Integer.parseInt(in[0]) - 1]);
		}

	}

}
