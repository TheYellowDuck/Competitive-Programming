package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumac_Sequences {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=(int) Double.parseDouble(input.readLine());
		int b=(int) Double.parseDouble(input.readLine());
		int i;
		for (i=1; b>=0; i++) {
			int c=a-b;
			a=b;
			b=c;
		}
		System.out.println(i);
	}

}
