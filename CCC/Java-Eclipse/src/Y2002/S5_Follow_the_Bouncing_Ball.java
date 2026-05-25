package Y2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_Follow_the_Bouncing_Ball {
	
	static int count = 0, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int Q = Integer.parseInt(br.readLine());
		bounce(P, Q, 0, 1);
		System.out.println(count);
	}
	
	static void bounce(double p1, double p2, int side1, int side2) {
		System.out.println(p1 + " " + p2 + " " + side);
		int n = side1 % 2 == 0 ? N : M;
		int m = side2 % 2 == 0 ? M : N;
		if ((p1 < 5 || p1 >= n - 5) || (p2 < 5 || p2 >= m - 5))
			return;
		double o = (side == 0 || side == 1 ? n : p1 * 2) - p1;
		double a = (side == 1 || side == 2 ? m : p2 * 2) - p2;
		double angle = Math.atan(o / a);
		System.out.println(n + " " + m + " " + o + " " + a + " " + angle + " " + Math.tan(angle));
		double l = n - ((m - a) * Math.tan(angle));
		side ++;
		side = side > 3 ? 0 : side;
		count ++;
		bounce(p2, l, side);
	}

}
