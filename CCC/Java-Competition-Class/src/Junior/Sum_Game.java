package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum_Game {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int gs=Integer.parseInt(input.readLine()), x=0, y=0, g=0;
		String[] in=input.readLine().split(" "), in2=input.readLine().split(" ");
		for (int i=0; i<gs; i++) {
			x+=Integer.parseInt(in[i]);
			y+=Integer.parseInt(in2[i]);
			if (x==y)
				g=i+1;
		}
		System.out.println(g);
	}

}
