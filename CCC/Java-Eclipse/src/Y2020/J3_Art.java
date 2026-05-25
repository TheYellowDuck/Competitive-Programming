package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J3_Art {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine()), bx = 100, by = 100, tx = 0, ty = 0;
		String[] in;
		while (n > 0) {
			in = input.readLine().split(",");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]);
			if (bx > x) bx = x;
			if (by > y) by = y;
			if (tx < x) tx = x;
			if (ty < y) ty = y;
			n--;
		}
		System.out.println((bx - 1) + "," + (by - 1));
		System.out.println((tx + 1) + "," + (ty + 1));
	}

}
