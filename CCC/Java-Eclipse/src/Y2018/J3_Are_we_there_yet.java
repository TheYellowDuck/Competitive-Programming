package Y2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J3_Are_we_there_yet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in = new StringTokenizer(br.readLine());
		int[] A = new int[5];
		for (int i = 1; i < 5; i ++) 
			A[i] = A[i - 1] + Integer.parseInt(in.nextToken());
		print (A);
		for (int i = 1; i < 5; i ++) {
			int C = A[i];
			for (int j = 0; j < 5; j ++) {
				if (j < i)
					A[j] += C;
				else
					A[j] -= C;
			}
			print (A);
		}
	}
	
	static void print(int[] A) {
		for (int i : A)
			System.out.print(i + " ");
		System.out.println();
	}

}
