package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Facebook_Hacker_Cup_2015_Round_1_Homework {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] notPrime = new int[10000001];
		for (int i = 2; i < notPrime.length; i++) {
			if (notPrime[i] == 0) 
				for (int j = i; j < notPrime.length; j += i)
					notPrime[j]++;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] in = br.readLine().split(" ");
			int A = Integer.parseInt(in[0]), B = Integer.parseInt(in[1]), K = Integer.parseInt(in[2]), tc = 0;
			while (A <= B) 
				if (notPrime[A++] == K) tc++;
			System.out.println("Case #" + t + ": " + tc);
		}

	}

}
