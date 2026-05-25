package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pinball_Ranking_MergeSort {
	static double I;
	public static double main() throws NumberFormatException, IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		I = 0;
		int n = Integer.parseInt(f.readLine());
		int[] a = new int[n];
		for (int x = 0; x < n; x++)
			a[x] = Integer.parseInt(f.readLine());
		mergeSort(a, 0, n - 1);
		return (I + n) / n;
	}
	public static void mergeSort(int[] a, int x, int z) {
		if (x < z) {
			int y = (x + z) / 2;
			mergeSort(a, x, y);
			mergeSort(a, y + 1, z);
			I += merge(a, x, y, z);
		}
	}
	public static double merge(int[] a, int x, int y, int z) {
		int[] newa = new int[z - x + 1];
		int xx = x;
		int yy = y + 1;
		int k = 0;
		double total = 0;
		while (xx <= y && yy <= z)
			if (a[xx] <= a[yy])
				newa[k++] = a[xx++];
			else {
				newa[k++] = a[yy++];
				total = total + (y + 1 - xx);
			}
		while (xx <= y)
			newa[k++] = a[xx++];
		while (yy <= z)
			newa[k++] = a[yy++];
		for (xx = x; xx <= z; xx++)
			a[xx] = newa[xx - x];
		return total;
	}
}
