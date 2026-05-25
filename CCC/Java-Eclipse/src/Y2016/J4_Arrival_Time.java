package Y2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J4_Arrival_Time {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(":");
		int M = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]), T = 2 * 60;
		//7-10 15-19
		if ((M > 10 * 60 && M <= 13 * 60) || (M <= 5 * 60 || M > 19 * 60)) 
			M += T;
//		if (T - (7 * 60 - M) > 0 || T - (15 * 60 - M) > 0) {
		else {
			if (T > (15 * 60 - M)) {
				if (M < 15 * 60) {
					T -= (15 * 60 - M);
					M = 15 * 60;
				}
				if (T * 2 > 19 * 60 - M) {
					T -= (19 * 60 - M) / 2;
					M += 19 * 60 - M + T;
				}
				else
					M += T * 2;
			}
			else {
				if (M < 7 * 60) {
					T -= (7 * 60 - M);
					M = 7 * 60;
				}
				if (T * 2 > 10 * 60 - M) {
					T -= (10 * 60 - M) / 2;
					M += 10 * 60 - M + T;
				}
				else
					M += T * 2;
			}
		}
		int H = (M / 60) % 24;
		M %= 60;
		System.out.printf("%02d:%02d", H, M);
	}

}
