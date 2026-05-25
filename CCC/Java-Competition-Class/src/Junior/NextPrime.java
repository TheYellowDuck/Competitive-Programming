package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NextPrime {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		BigInteger num=new BigInteger(input.readLine());
		if (num.remainder(new BigInteger("2")).compareTo(new BigInteger("0"))==0 && num.compareTo(new BigInteger("1"))!=0 && num.compareTo(new BigInteger("2"))!=0)
			num=num.add(new BigInteger("1"));
		for (BigInteger a=num;; a=a.add(new BigInteger("2"))) {
			if (isPrime(a)==true) {
				System.out.println(a);
				break;
			}
			if (a.compareTo(new BigInteger("1"))==0 || a.compareTo(new BigInteger("0"))==0)
				a=a.subtract(new BigInteger("1"));
		}
	}
	public static boolean isPrime(BigInteger a) {
		if (a.compareTo(new BigInteger("2"))==0)
		   return true;
		if (a.compareTo(new BigInteger("1"))==0 || a.remainder(new BigInteger("2")).compareTo(new BigInteger("0"))==0)
			return false;
		for (BigInteger i=new BigInteger("3"); i.multiply(i).compareTo(a)==-1 || i.multiply(i).compareTo(a)==0; i=i.add(new BigInteger("2"))) {
			if (a.remainder(i).compareTo(new BigInteger("0"))==0)
		    	return false;
		}
		return true;
	}
}
