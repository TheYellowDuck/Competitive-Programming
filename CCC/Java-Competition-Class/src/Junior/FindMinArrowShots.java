package Junior;

import java.util.Arrays;

public class FindMinArrowShots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] p = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		System.out.println(new FindMinArrowShots().findMinArrowShots(p));
	}

	static int len;

	public int findMinArrowShots(int[][] p) {
//		Arrays.sort(p, new java.util.Comparator<int[]>() {
//			@Override
//			public int compare(int[] a, int[] b) {
//				return Integer.compare(a[0], b[0]);
//			}
//		});
		len = p.length;
		return f(p, len, 0, 1, len);
	}

	private int f(int[][] p, int l, int b, int t, int m) {
		int[][] c = p.clone();
		int[] coor = new int[2];
		int v = l, s1, s2;
		for (; t < len; t++) {
			for (int[] n : p) {
				System.out.println(Arrays.toString(n));
			}
			System.out.println();
			if (p[b][1] >= p[t][0]) {
//				if (i + 1 == len) {
//					return len - i;
//				}
				if (t + 1 < len) {
					s1 = p[t][0];
					s2 = p[b][0];
					coor[0] = Math.max(s1, s2);
					s1 = p[t][1];
					s2 = p[b][1];
					coor[1] = Math.min(s1, s2);
					c[t] = coor.clone();
					c[b] = null;
					System.out.println();
					v = f(c, l - 1, t, t + 1, m);
				}
				System.out.println(m);
				if (v == 1) {
					return 1;
				} else if (v < m) {
					m = v;
				}
				System.out.println(m);
				c[t] = p[t].clone();
				c[b] = p[b].clone();
			}
		}
		System.out.println();
		System.out.println(m == len ? v : m);
		return m == len ? v : m;
	}
}
