package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Picture_Perfect {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int c=(int) Double.parseDouble(input.readLine());
		while (c!=0) {
			int x=(int) Math.sqrt(c);
			int y=(int) Math.ceil(Math.sqrt(c));
			int bool=0;
			for (; bool==0 && x>0; x--) {
				for (; bool==0 && x*y<=c; y++) {
					if (x*y==c) {
						bool=1;
						System.out.println("Minimum perimeter is "+(x+y)*2+" with dimensions "+x+" x "+y);
						break;
					}
				}
			}
			c=(int) Double.parseDouble(input.readLine());
		}
	}

}
