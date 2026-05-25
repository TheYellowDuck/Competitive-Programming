package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J5_S2_Modern_Art {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
		boolean[] R = new boolean[M], C = new boolean[N];
		int RC = 0, CC = 0;
		while (K > 0) {
			String[] in = br.readLine().split(" ");
			int line = Integer.parseInt(in[1]) - 1;
			if (in[0].contentEquals("R")) {
				if (R[line]) {
					RC--;
					R[line] = false;
				}
				else {
					RC++;
					R[line] = true;
				}
			}
			else {
				if (C[line]) {
					CC--;
					C[line] = false;
				}
				else {
					CC++;
					C[line] = true;
				}
			}
			K--;
		}
		System.out.println((RC * N) + (CC * M) - (RC * CC * 2));
	}

}
