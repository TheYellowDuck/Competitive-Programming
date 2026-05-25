package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC_19_S2_Pretty_Average_Primes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = 2 * Integer.parseInt(br.readLine());
			for (int i = 2; i <= n; i++) {
				int j = n - i;
				if (isPrime(i) && isPrime(j)) {
					System.out.println(i + " " + j);
					break;
				}
				
			}
			t--;
		}

	}
	
	public static boolean isPrime (int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) 
			if (n % i == 0) return false;
		return true;
	}

}
