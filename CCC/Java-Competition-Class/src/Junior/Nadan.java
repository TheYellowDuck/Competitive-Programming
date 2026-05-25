package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nadan {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(input.readLine()), n=Integer.parseInt(input.readLine()), a=1;
		for (n-=1; n>0; n--, a++) {
			System.out.println(a);
			k-=a;
		}
		System.out.println(k);
	}

}