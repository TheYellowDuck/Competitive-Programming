package Y2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_Blood_Distribution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int[] B = new int[8];
		for (int i = 0; i < 8; i ++) 
			B[i] = Integer.parseInt(in[i]);
		in = br.readLine().split(" ");
		int count = 0;
		for (int i = 0; i < 8; i ++) {
			int v = Integer.parseInt(in[i]);
			int t = 0;
			for (int j = 0; j <= i; j ++) {
				if (v == 0)
					break;
				if (i % 2 == 0 && j % 2 == 1)
					continue;
				if ((i == 4 || i == 5) && (j == 2 || j == 3))
					continue;
				if (i % 2 == 1 && j % 2 == 0)
					t = 1;
				if (i % 2 == 1 && j % 2 == 1)
					t = -1;
				if (j + t <= 8) {
					if (v <= B[j + t]) {
						count += v;
						B[j + t] -= v;
						v = 0;
					}
					else {
						count += B[j + t];
						v -= B[j + t];
						B[j + t] = 0;
					}
				}
			}
		}
		System.out.println(count);
	}

}
