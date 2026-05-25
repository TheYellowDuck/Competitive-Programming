package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pretty_Average_Numbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int lines=(int) Double.parseDouble(input.readLine());
		String[] array=new String[lines];
		for (int i=0; i<lines; i++) {
			int a=((int) Double.parseDouble(input.readLine()));
			int n=a, m=a;
			for (; n>1; n++, m++) {
				if (isPrime(n)==true && isPrime(m)==true) {
					array[i]=String.valueOf(n).concat(" ".concat(String.valueOf(m)));
					break;
				}
			}
		}
		for (String i:array) {
			System.out.println(i);
		}
	}
	public static boolean isPrime(int a) {
		if (a==2)
		   return true;
		if (a==1 || a%2==0)
			return false;
		for (int i=3; i*i<=a; i+=2) {
			if (a%i==0)
		    	return false;
		}
		return true;
	}
}
