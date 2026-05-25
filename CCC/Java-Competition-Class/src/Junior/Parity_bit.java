package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parity_bit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num, c;
		for (int i=0; i<5; i++) {
			num=Integer.parseInt(input.readLine());
			c=0;
			while (num>0) {
				c=num%2==1?c+1:c;
				num/=2;
			}
			System.out.println(c%2==0?0:1);
		}

	}

}

