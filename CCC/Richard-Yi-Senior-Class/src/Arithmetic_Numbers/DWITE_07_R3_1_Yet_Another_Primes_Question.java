package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DWITE_07_R3_1_Yet_Another_Primes_Question {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 5;
		while (T > 0) {
			int n = Integer.parseInt(br.readLine()), c = 0;
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					c++;
					while (n % i == 0) {
						n /= i;
					}
				}
			}
			if (n > 1) c++;
			System.out.println(c == 3 ? "valid" : "not");
			T--;
		}

	}

}
