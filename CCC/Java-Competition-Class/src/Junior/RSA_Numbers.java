package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSA_Numbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		int y=(int) Double.parseDouble(input.readLine());
		int z=0;
		for (int i=x; i<=y; i++) {
			int c=2;
			for (int j=2; j*j<=i-i/4; j++) {
				if (i%j==0)
					c+=2;
				if (c>4)
					break;
			}
			if (c==4)
				z++;
		}
		System.out.println("The number of RSA numbers between "+x+" and "+y+" is "+z);
	}

}
