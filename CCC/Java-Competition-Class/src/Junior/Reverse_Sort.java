package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_Sort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine()), c = 0;
		String[] in = input.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(in[i]);
		for (n--; n > 0; n--)
			for (int i = n - 1; i >= 0; i--)
				if (a[n] > a[i])
					c++;
		System.out.println(c);

	}

}
