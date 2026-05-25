package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2_Silent_Auction {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), h = 0;
		String name = "";
		while (N > 0) {
			String in = br.readLine();
			int bid = Integer.parseInt(br.readLine());
			if (bid > h) {
				h = bid;
				name = in;
			}
			N--;
		}
		System.out.println(name);

	}

}
