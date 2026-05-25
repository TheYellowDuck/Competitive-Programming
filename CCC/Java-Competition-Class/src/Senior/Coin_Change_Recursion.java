package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_Change_Recursion {

	static int[] array;
	static Integer[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(input.readLine()), cns = Integer.parseInt(input.readLine());
		array = new int[cns];
		ans = new Integer[target + 1];
		ans[0] = 0;
		for (int i = 0; i < cns; i++)
			array[i] = Integer.parseInt(input.readLine());
		int c = coins(target);
		System.out.println(c);
	}

	public static int coins(int d) {
		Integer a = ans[d];
		if (a != null)
			return a;
		int min = Integer.MAX_VALUE, cns;
		for (int c : array) {
			if (d - c >= 0) {
				cns = coins(d - c);
				if (cns != -1) {
					min = Math.min(min, 1 + cns);
				}
			}
		}
		min = min == Integer.MAX_VALUE ? -1 : min;
		ans[d] = min;
		return min;
	}

}
