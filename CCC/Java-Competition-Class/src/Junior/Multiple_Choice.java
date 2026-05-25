package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple_Choice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine());
		char[] s=new char[n];
		for (int i=0; i<n; i++) {
			s[i]=input.readLine().charAt(0);
		}
		int c=0;
		for (int i=0; i<n; i++) {
			if (s[i]==input.readLine().charAt(0))
				c++;
		}
		System.out.println(c);
	}

}
