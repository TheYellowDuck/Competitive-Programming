package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Missing_Art {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] codes;
		char[] icode;
		BigInteger code, ten=new BigInteger("10"), hundred=new BigInteger("100");
		int t, x, y, z;
		String[] in;
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			list.clear();
			in=input.readLine().split(" ");
			t=Integer.parseInt(in[0]);
			x=Integer.parseInt(in[1]);
			y=Integer.parseInt(in[2]);
			z=Integer.parseInt(in[3]);
			codes=new BigInteger[t];
			for (int j=0; j<t; j++) {
				icode=input.readLine().toCharArray();
				code=new BigInteger("0");
				for (int n:icode) {
					n-=48;
					if (n==0) n=z;
					else if (n%2==0) n+=x;
					else {
						n-=y;
						if (n<0) n=0;
					}
					code=code.multiply(n>9?hundred:ten).add(BigInteger.valueOf(n));
				}
				codes[j]=code;
			}
			input.readLine();
			for (int j=0; j<t; j++) {
				code=new BigInteger(input.readLine());
				if (!codes[j].equals(code)) list.add(j+1);
			}
			if (list.isEmpty()) System.out.println("MATCH");
			else {
				System.out.print("FAIL: ");
				t=list.size()-1;
				for (int j=0; j<t; j++) System.out.print(list.get(j)+",");
				System.out.println(list.get(t));
			}
			input.readLine();
		}
		input.close();
	}

}
