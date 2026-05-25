package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shifty_Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), y=Integer.parseInt(input.readLine()), sum=0;
		for (int i=0; i<=y; i++, sum+=x, x*=10) {}
		System.out.println(sum);	
	}

}
