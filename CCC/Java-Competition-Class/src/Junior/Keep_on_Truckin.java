package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keep_on_Truckin {
	static int[] array;
	static Integer[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[7001];
		array[0] = 1;
		array[990] = 1;
		array[1010] = 1;
		array[1970] = 1;
		array[2030] = 1;
		array[2940] = 1;
		array[3060] = 1;
		array[3930] = 1;
		array[4060] = 1;
		array[4970] = 1;
		array[5030] = 1;
		array[5990] = 1;
		array[6010] = 1;
		array[7000] = 1;
		int m = Integer.parseInt(input.readLine()) - 1, M = Integer.parseInt(input.readLine()) + 1,
				add = Integer.parseInt(input.readLine()), sub = 14;
		for (; add > 0; add--, sub++)
			array[Integer.parseInt(input.readLine())] = 1;
		long[] ans = new long[sub];
		int[] motels = new int[sub];
		for (int i = 0; i < 7001; i++)
			if (array[i] == 1)
				motels[add++] = i;
		ans[0] = 1;
		sub--;
		for (int i = 0; i < sub; i++) {
			for (int j = i + 1; j <= sub; j++) {
				add = motels[j] - motels[i];
				if (add > m && add < M)
					ans[j] += ans[i];
				else if (add >= M)
					break;
			}
		}
		System.out.println(ans[sub]);
	}

}
