package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quadrant_Selection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), y=Integer.parseInt(input.readLine());
		if (x>0) {
			if (y>0)
				System.out.println(1);
			else 
				System.out.println(4);
		}
		else {
			if (y>0)
				System.out.println(2);
			else 
				System.out.println(3);
		}
	}

}
