package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
		long t1 = System.nanoTime();
		while (a != b) {
			if (a == 0 || b == 0) break;
			if (a < b) 
				b = b % a;
			else 
				a = a % b;
		}
		System.out.println("Answer: " + Math.max(a, b) + " Time Spent: " + (System.nanoTime() - t1));
		long t2 = System.nanoTime();
		System.out.println("Answer: " + gcd(a, b) + " Time Spent: " + (System.nanoTime() - t2));
	}
	
	static int gcd(int a, int b) {
		if (a == 0) return b;
		else return gcd(b % a, a);
	}

}
