package Sorting_Stacks_and_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Round_1A_2021_Code_Jam_2021_Append_Sort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i ++) {
			int N = Integer.parseInt(br.readLine()), count = 0;
			String[] in = br.readLine().split(" ");
			long a = Long.parseLong(in[0]);
			for (int j = 1; j < N; j ++) {
				long b = Long.parseLong(in[j]);
				if (a < b)
					continue;
				long c = b;
				for (int x = 0; x < ; x ++) {
					
				}
				
				a = b;
			}
		}

	}
	

}
