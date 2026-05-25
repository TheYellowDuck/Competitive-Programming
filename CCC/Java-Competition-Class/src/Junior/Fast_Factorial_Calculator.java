package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fast_Factorial_Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		BigInteger x, ans, one=new BigInteger("1"), two=new BigInteger("2"), mod=new BigInteger("4294967296");
		for (; n>0; n--) {
			x=new BigInteger(input.readLine());
			ans=new BigInteger("1");
			for (; x.compareTo(two)!=-1; x=x.subtract(one)) ans=ans.multiply(x);
			System.out.println(ans.remainder(mod));
		}

	}

}
