package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tle16c6s2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int x1 = Integer.parseInt(in[0]), y1 = Integer.parseInt(in[1]);
		in = br.readLine().split(" ");
		int x2 = Integer.parseInt(in[0]), y2 = Integer.parseInt(in[1]);
		int rise = y1 - y2, run = x1 - x2;
		double slope = (double) rise/run;
		double yindex = y1 - slope * x1; // (0, yindex)
		double xindex = -yindex / slope; // (xindex, 0)
		double area = xindex * yindex / 2;
		if (area < 0) {
			
		}
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
		System.out.println(rise + " " + run + " " + slope);
		System.out.println(yindex + " " + xindex);
		System.out.println(area);
	}

}
