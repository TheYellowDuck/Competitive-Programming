package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Special_Day {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(input.readLine());
		int d=Integer.parseInt(input.readLine());
		if (m==2) {
			if (d==18)
				System.out.println("Special");
			else if (d>18)
				System.out.println("After");
			else
				System.out.println("Before");
		}
		else if (m<2)
			System.out.println("Before");
		else
			System.out.println("After");
	}

}
