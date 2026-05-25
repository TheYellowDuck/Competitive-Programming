package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Double_Dice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), a=100, b=100;
		for (int i=0; i<x; i++) {
			char[] s=input.readLine().toCharArray();
			if (s[0]>s[2])
				b-=s[0]-'0';
			else if (s[0]<s[2])
				a-=s[2]-'0';
		}
		System.out.println(a+"\n"+b);
	}

}
