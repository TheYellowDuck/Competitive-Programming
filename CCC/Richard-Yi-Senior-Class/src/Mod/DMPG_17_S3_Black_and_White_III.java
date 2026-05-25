package Mod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMPG_17_S3_Black_and_White_III {
	
	static int MOD = (int) (1e9 + 7);
	
	static long pow(long b, long e, long m) {
		if (e == 0) return 1;
		if (e % 2 == 1) return b * pow(b * b % m, e / 2, m) % m;
		else return pow(b * b % m, e / 2, m);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//(2 ^ 4 ^ m - 1) ^ b
		//((2 ^ ((4 ^ m) % (p - 1) - 1) % p) ^ b % p
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int K = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]), power = 1 << K, b = 0;
		
		for (int i = 0; i < power; i ++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < power; j ++) {
				if (in[j].contentEquals("#"))
					b ++;
			}
		}
		
		long p1 = pow(4, M, MOD - 1), p2 = (pow(2, p1, MOD) - 1 + MOD) % MOD, p3 = pow(p2, b, MOD);
		System.out.println(p3);
	}

}
