package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tournament_Selection {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int c=0;
		for (int i=0; i<6; i++) {
			if (input.readLine().contentEquals("W"))
				c++;
		}
		if (c==0)
			System.out.println(-1);
		else
			System.out.println(c>2?c>4?1:2:3);
	}

}
