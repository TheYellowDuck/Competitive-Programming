package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_Crazy_Fencing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double ans = 0;
		int n = Integer.parseInt(br.readLine()), p = 0;
		String[] s = br.readLine().split(" "), b = br.readLine().split(" ");
		if (s.length != 0) p = Integer.parseInt(s[0]);
		for (int i = 0; i < n; i++) {
			int t = p, x = Integer.parseInt(b[i]);
			p = Integer.parseInt(s[i + 1]);
			ans += Math.min(t, p) * x + ((double) (Math.abs(t - p) * x) / 2);
		}
		System.out.println(ans);
	}

}
