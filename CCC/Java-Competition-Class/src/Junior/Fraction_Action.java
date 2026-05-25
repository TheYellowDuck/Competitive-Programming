package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fraction_Action {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		BigInteger x=new BigInteger(input.readLine());
		BigInteger y=new BigInteger(input.readLine());
		BigInteger z=x.gcd(y);
		x=x.divide(z);
		y=y.divide(z);
		BigInteger w=x.remainder(y);
		x=x.divide(y);
		if (x.compareTo(new BigInteger("0"))==1 && w.compareTo(new BigInteger("0"))==1)
			System.out.println(x+" "+w+"/"+y);
		else if (x.compareTo(new BigInteger("0"))==1)
			System.out.println(x);
		else
			System.out.println(w+"/"+y);
	}

}
