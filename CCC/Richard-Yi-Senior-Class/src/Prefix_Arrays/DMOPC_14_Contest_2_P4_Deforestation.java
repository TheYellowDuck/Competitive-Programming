package Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMOPC_14_Contest_2_P4_Deforestation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] psa = new int[T + 1];
		
		for (int t = 1; t <= T; t++) 
			psa[t] = psa[t - 1] + Integer.parseInt(br.readLine());
		
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String[] in = br.readLine().split(" ");
			System.out.println(psa[Integer.parseInt(in[1]) + 1] - psa[Integer.parseInt(in[0])]);
		}
	}

}
