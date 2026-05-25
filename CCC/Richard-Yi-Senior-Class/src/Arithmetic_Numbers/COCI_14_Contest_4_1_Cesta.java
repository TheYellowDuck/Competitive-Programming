package Arithmetic_Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class COCI_14_Contest_4_1_Cesta {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		int sum = 0;
		boolean zero = false;
		for (char i : a) {
			if (i == '0') zero = true;
			sum += i - '0';
		}
		if (zero && sum % 3 == 0) {
			Arrays.sort(a);
			for (int i = a.length - 1; i >= 0; i--)
				System.out.print(a[i]);
			System.out.println();
		}
		else System.out.println(-1);
	}

}
