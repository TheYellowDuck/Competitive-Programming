package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tri {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] str=input.readLine().split(" ");
		int x=Integer.parseInt(str[0]), y=Integer.parseInt(str[1]), z=Integer.parseInt(str[2]);
		if (x+y==z) System.out.println(x+"+"+y+"="+z);
		else if (x-y==z) System.out.println(x+"-"+y+"="+z);
		else if (x*y==z) System.out.println(x+"*"+y+"="+z);
		else if (x/y==z && x%y==0) System.out.println(x+"/"+y+"="+z);
		else if (z+y==x) System.out.println(x+"="+y+"+"+z);
		else if (y-z==x) System.out.println(x+"="+y+"-"+z);
		else if (z*y==x) System.out.println(x+"="+y+"*"+z);
		else if (y/z==x && y%z==0) System.out.println(x+"="+y+"/"+z);
	}

}