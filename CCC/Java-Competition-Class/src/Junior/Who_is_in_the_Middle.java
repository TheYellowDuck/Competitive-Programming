package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Who_is_in_the_Middle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		double a=Double.parseDouble(input.readLine());
		double b=Double.parseDouble(input.readLine());
		double c=Double.parseDouble(input.readLine());
		if ((a<b && a>c) || (a>b && a<c)) 
			System.out.println((int) a);
		else if ((b<a && b>c) || (b>a && b<c)) 
			System.out.println((int) b);
		else
			System.out.println((int) c);
	}

}
