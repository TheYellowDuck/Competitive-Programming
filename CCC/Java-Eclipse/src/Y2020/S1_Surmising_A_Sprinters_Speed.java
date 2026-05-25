package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_Surmising_A_Sprinters_Speed {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		Vector[] a = new Vector[n--];
		while (n >= 0) {
			String[] in = input.readLine().split(" ");
			a[n] = new Vector(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
			n--;
		}
		Arrays.sort(a, (x, y) -> x.t - y.t);
		double max = 0;
		for (int i = 1; i < a.length; i++) 
			max = Math.max(max, (double) (Math.abs(a[i].x - a[i - 1].x)) / (a[i].t - a[i - 1].t));
		System.out.println(max);
	}
	
	static class Vector {
		int t, x;
		Vector(int t, int x) {
			this.t = t;
			this.x = x;
		}
	}

}
