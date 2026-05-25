package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vacation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(input.readLine());
		int[][] a = new int[len][3], ans = new int[len][3];
		String[] in;
		for (int i = 0; i < len; i++) {
			in = input.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				a[i][j] = Integer.parseInt(in[j]);
			}
		}
		ans[0] = a[0];
		for (int i = 1; i < len; i++) {
//			for (int j=0; j<3; j++) {
//				m=Integer.MIN_VALUE;
//				for (int n=0; n<3; n++) {
//					if (n!=j)
//						m=Math.max(ans[i-1][n], m);
//				}
//				ans[i][j]=a[i][j]+m;
//			}
			ans[i][0] = Math.max(ans[i - 1][1], ans[i - 1][2]) + a[i][0];
			ans[i][1] = Math.max(ans[i - 1][0], ans[i - 1][2]) + a[i][1];
			ans[i][2] = Math.max(ans[i - 1][0], ans[i - 1][1]) + a[i][2];
		}
		System.out.println(Math.max(Math.max(ans[len - 1][0], ans[len - 1][1]), ans[len - 1][2]));

	}

}
