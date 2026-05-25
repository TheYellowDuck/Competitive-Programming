package Y2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S2_Jerseys {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> mp = new HashMap<>();
		for (int i = 1; i <= N; i ++) {
			char s = br.readLine().charAt(0);
			mp.put(i, s);
		}
		int count = 0;
		while (M > 0) {
			String[] in = br.readLine().split(" ");
			char s = in[0].charAt(0);
			int n = Integer.parseInt(in[1]);
			if (mp.getOrDefault(n, 't') <= s) {
				mp.remove(n);
				count ++;
			}
			M --;
		}
		System.out.println(count);
	}

}
