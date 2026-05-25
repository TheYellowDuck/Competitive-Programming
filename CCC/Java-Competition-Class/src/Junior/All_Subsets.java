package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class All_Subsets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int l = in.length, m=0, t=1, b;
		for (int i=0; i<l; i++) t*=2;
		int[] array = new int[l];
		for (int i = 0; i < l; i++)
			array[i] = Integer.parseInt(in[i]);
		while (m<t) {
			for (int i=0; i<l; i++) {
				b=1;
				for (int j=0; j<i; j++) b*=2;
				if ()
			}
		}
		
	}

}
