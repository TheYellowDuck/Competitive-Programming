package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Frog_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int len = Integer.parseInt(in[0]), k = Integer.parseInt(in[1]), m;
		in = input.readLine().split(" ");
		int[] ans = new int[len], height = new int[len];
		for (int i = 0; i < len; i++) {
			height[i] = Integer.parseInt(in[i]);
		}
		ans[0] = 0;
		ans[1] = Math.abs(height[0] - height[1]);
		for (int i = 2; i < len; i++) {
			m = Integer.MAX_VALUE;
			for (int j = i - 1, n = 0; j >= 0 && n < k; j--, n++) {
				m = Math.min(m, ans[j] + Math.abs(height[i] - height[j]));
			}
			ans[i] = m;
		}
		System.out.println(ans[len - 1]);
	}

}
