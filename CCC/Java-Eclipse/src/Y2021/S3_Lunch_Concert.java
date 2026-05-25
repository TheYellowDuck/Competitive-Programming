package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_Lunch_Concert {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		while (N > 0) {
			String[] in = br.readLine().split(" ");
			int P = Integer.parseInt(in[0]), S = Integer.parseInt(in[1]), D = Integer.parseInt(in[2]);
			
			N--;
		}
		
		System.out.println(ans);

	}

}
