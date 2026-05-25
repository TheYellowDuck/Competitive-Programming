package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2_Epidemiology {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(input.readLine()), t = Integer.parseInt(input.readLine()), i = t, r = Integer.parseInt(input.readLine()), d = 0;
		while (t < p) {
			i *= r;
			t += i;
			d++;
		}
		System.out.println(d);
	}

}
