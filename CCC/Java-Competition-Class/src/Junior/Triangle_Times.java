package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle_Times {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), y=Integer.parseInt(input.readLine()), z=Integer.parseInt(input.readLine());
		if (x+y+z==180) {
			if (x!=y && x!=z && y!=z)
		       System.out.println("Scalene");
			else if(x==y && x==z)
				System.out.println("Equilateral");
			else
				System.out.println("Isosceles");
		}
		else
			System.out.println("Error");
	}
}
