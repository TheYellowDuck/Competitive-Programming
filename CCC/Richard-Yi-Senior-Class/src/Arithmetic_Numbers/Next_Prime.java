package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Next_Prime {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 2) System.out.println(2);
		else {
			if (n % 2 == 0) n++;
			while (true) {
				if (isPrime(n)) break;
				n += 2;
			}
		}
		System.out.println(n);
	}
	
	public static boolean isPrime (int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) 
			if (n % i == 0) return false;
		return true;
	}

}
