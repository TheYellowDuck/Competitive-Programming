package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_Joshs_Double_Bacon_Deluxe {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] B = new int[N], BC = new int[500001];
		double[] prob = new double[N];
		String[] in = br.readLine().split(" ");
		for (int i = 0; i < N; i ++) {
			int v = Integer.parseInt(in[i]);
			B[i] = v;
			BC[v] ++;
		}
		prob[0] = (double) BC[B[0]] -- / N;
		int BL = N;
		if (BC[B[1]] > 1) {
			prob[1] = 1;
			BC[B[1]] --;
		}
		else
			prob[1] = prob[0] + (double) BC[B[1]] / BL;
		BL --;
		System.out.println(prob[0]);
		System.out.println(prob[1]);
		for (int i = 2; i < N; i ++) {
			if (BC[B[i]] > 1) {
				prob[i] = 1;
				BC[B[i]] --;
			}
			else
				prob[i] = prob[0] + (prob[i - 1] - prob[0]) * (double) BC[B[i]] / BL;
			BL --;
//			prob[i] = prob[0] + (1 - prob[i - 1]) * ((double) BC[B[i]] -- / BL --);
			System.out.println(prob[i] + " = " + prob[0] + " + (" + prob[i - 1] + " - " + prob[0] + ") * (double) " + BC[B[i]] + " / " + (BL + 1));
		}
		System.out.println(prob[N - 1]);
	}

}
