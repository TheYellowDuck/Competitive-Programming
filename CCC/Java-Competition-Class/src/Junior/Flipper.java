package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flipper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int a=1, b=2, c=3, d=4;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] in=input.readLine().toCharArray();
		for (char i:in)
			switch (i) {
			case 'H':
				int r=a;
				a=c;
				c=r;
				r=b;
				b=d;
				d=r;
				break;
			case 'V':
				r=a;
				a=b;
				b=r;
				r=c;
				c=d;
				d=r;
				break;
			}
		System.out.println(a+" "+b+"\n"+c+" "+d);
	}

}
