package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int p=91;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		p+=(int) Double.parseDouble(input.readLine());
		p+=(int) Double.parseDouble(input.readLine())*3;
		p+=(int) Double.parseDouble(input.readLine());
		System.out.println("The 1-3-sum is "+p);
	}

}
