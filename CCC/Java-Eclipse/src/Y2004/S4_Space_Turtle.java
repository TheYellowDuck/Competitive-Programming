package Y2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_Space_Turtle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		Point T = new Point(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
		in = br.readLine().split(" ");
		Point P = new Point(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
		char d = '.';
		while (d != 'E') {
			in = br.readLine().split(" ");
			int l = Integer.parseInt(in[0]);
			d = in[1].charAt(0);
			
		}
	}
	
	static class Point {
		int[] pos = new int[3];
		int[] da = new int[] {0, 0, 1};
		int f = 2, up = -1;
		Point(int x, int y, int z) {
			pos[0] = x;
			pos[1] = y;
			pos[2] = z;
		}
		
		void update(int l, char nd) {
			pos[f] += l * da[f];
			switch (nd) {
			case 'L':
				
				
				break;
			}
		}
		
	}

}
