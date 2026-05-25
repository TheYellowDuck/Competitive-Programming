package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thor_Goes_for_the_Papaya {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(input.readLine()), a, b=Integer.parseInt(input.readLine());
		System.out.print("Thanos is on Planet: ");
		for (int i=0; i<=t; i++) {
			a=b;
			b=Integer.parseInt(input.readLine());
			System.out.print((char) ((a*b)%26+65));
		}

	}

}
