package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uneven_Sand {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int l=1, h=2000000000, m=1000000000;
		System.out.println(m);
		System.out.flush();
		char in=input.readLine().charAt(0);
		while (in!='O') {
			if (in=='S')
				l=m;
			else 
				h=m;
			m=l+(h-l)/2;
			System.out.println(m);
			System.out.flush();
			in=input.readLine().charAt(0);
		}
		
	}

}
