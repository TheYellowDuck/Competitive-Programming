package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Merge_Sort {

	public static int[] merge(int[] array, int l, int h) {
		Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
		int m = (l + h) / 2, v1, v2;
		if (m != l) {
			array = merge(array, l, m);
			for (int i = l; i <= m; i++)
				q1.add(array[i]);
		} else
			q1.add(array[l]);
		m++;
		if (m != h) {
			array = merge(array, m, h);
			for (; m <= h; m++)
				q2.add(array[m]);
		} else
			q2.add(array[h]);
		for (; l <= h; l++) {
			v1 = q1.peek() == null ? Integer.MAX_VALUE : q1.peek();
			v2 = q2.peek() == null ? Integer.MAX_VALUE : q2.peek();
			if (v1 < v2) {
				array[l] = v1;
				q1.poll();
			} else {
				array[l] = v2;
				q2.poll();
			}
		}
		return array;
	}

	public static void main(int[] array) throws IOException {
		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		String[] in = input.readLine().split(" ");
//		int l = in.length;
//		int[] array = new int[l];
//		for (int i = 0; i < l; i++)
//			array[i] = Integer.parseInt(in[i]);
		array = merge(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

	}

}
