package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_Change_Iterative {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(input.readLine()), cns = Integer.parseInt(input.readLine());
		int[] array = new int[cns];
		int[] ans = new int[target + 1];
		for (int i = 0; i < cns; i++)
			array[i] = Integer.parseInt(input.readLine());
		for (int i = 1; i < ans.length; i++) {
			int min = Integer.MAX_VALUE, temp;
			for (int j = 0; j < array.length; j++) {
				temp = i - array[j];
				if (temp >= 0 && array[j] >= 0 && ans[temp] >= 0 && ans[temp] < min) {
					min = ans[temp];
				}
			}
			if (min < Integer.MAX_VALUE) {
				ans[i] = min + 1;
			} else {
				ans[i] = -1;
			}
		}
		System.out.println(ans[ans.length - 1]);
	}

}
