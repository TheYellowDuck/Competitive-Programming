package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Happy_or_Sad {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] str=input.readLine().toCharArray();
		int c=0, co=0;
		for (int i=2; i<str.length; i++) {
			if (str[i-2]==':' && str[i-1]=='-') {
				switch (str[i]) {
				case ')':
					c++;
					co++;
					break;
				case '(':
					c--;
					co++;
					break;
				}
			}
		}
		if (co!=0)
			System.out.println(c>=0?c==0?"unsure":"happy":"sad");
		else
			System.out.println("none");
	}

}
