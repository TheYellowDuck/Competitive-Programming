package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Frog_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(input.readLine());
		String[] in = input.readLine().split(" ");
		int[] ans = new int[len], cost = new int[len];
		for (int i = 0; i < len; i++) {
			cost[i] = Integer.parseInt(in[i]);
		}
		ans[0] = 0;
		ans[1] = Math.abs(cost[0] - cost[1]);
		for (int i = 2; i < len; i++) {
			ans[i] = Math.min(ans[i - 2] + Math.abs(cost[i] - cost[i - 2]),
					ans[i - 1] + Math.abs(cost[i] - cost[i - 1]));
		}
		System.out.println(ans[len - 1]);

	}

}
