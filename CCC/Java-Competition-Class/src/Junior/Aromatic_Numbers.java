package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aromatic_Numbers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] str=input.readLine().toCharArray();
		int sum=0, a=0, b=Integer.MAX_VALUE;
		for (int i=0; i<str.length; i+=2) {
			switch (str[i+1]) {
			case 'I':
				a=1;
				break;
			case 'V':
				a=5;
				break;
			case 'X':
				a=10;
				break;
			case 'L':
				a=50;
				break;
			case 'C':
				a=100;
				break;
			case 'D':
				a=500;
				break;
			case 'M':
				a=1000;
				break;
			}
			sum+=(str[i]-'0')*a;
			if (a>b)
				sum-=2*(str[i-2]-'0')*b;
			b=a;
		}
		System.out.println(sum);
	}

}
