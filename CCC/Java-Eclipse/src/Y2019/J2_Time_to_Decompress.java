package Y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2_Time_to_Decompress {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N > 0) {
			String[] in = br.readLine().split(" ");
			int M = Integer.parseInt(in[0]);
			while (M > 0) {
				System.out.print(in[1]);
				M--;
			}
			System.out.println();
			N--;
		}

	}

}
