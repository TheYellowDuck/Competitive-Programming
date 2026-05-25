package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class COCI_08_Contest_5_2_Jabuka {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int R = Integer.parseInt(in[0]), G = Integer.parseInt(in[1]);
		for (int i = 1; i * i <= R; i++) {
			if (R % i == 0) {
				if (G % i == 0) System.out.println(i + " " + (R / i) + " " + (G / i));
				if (i * i != R) {
					int j = R / i;
					if (G % j == 0) System.out.println(j + " " + (R / j) + " " + (G / j));
				}
			}
		}

	}

}
