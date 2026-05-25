package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pennies_in_the_Ring {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		while (x!=0) {
			double xx=x*x;
			int points=0;
			for (int i=1; xx>0; i+=2) {
				xx=xx-i;
				points+=(int) Math.sqrt(xx)*2+1;
			}
			points*=2;
			points+=x*2+1;
			System.out.println(points);
			x=(int) Double.parseDouble(input.readLine());
		}
	}

}
