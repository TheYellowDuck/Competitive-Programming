package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cool_Numbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		int y=(int) Double.parseDouble(input.readLine());
		int c=0;
		int i=(int) Math.pow(x, 1/6);
		int f=(int) Math.pow(i, 6);
		while (f<=y) {
			if (x<=f && f<=y)
				c++;
			i++;
			if (i==35)
				break;
			f=(int) Math.pow(i, 6);
		}
		System.out.println(c);
	}

}
