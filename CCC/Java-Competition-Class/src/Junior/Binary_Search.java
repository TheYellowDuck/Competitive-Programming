package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary_Search {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int h = in.length, l=0;
		int[] array = new int[h];
		for (int i = 0; i < h; i++)
			array[i] = Integer.parseInt(in[i]);
		h--;
		int m=(l+h)/2, c=array[m], s=Integer.parseInt(input.readLine());
		while (c!=s) {
			if (c<s) 
				l=m;
			else if (c>s)
				h=m;
			m=(l+h)/2;
			c=array[m];
			if (m==l) break;
		}
		System.out.println(l==m?l:m);

	}

}
