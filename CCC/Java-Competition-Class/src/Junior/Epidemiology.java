package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Epidemiology {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int P=Integer.parseInt(input.readLine()), N=Integer.parseInt(input.readLine()), R=Integer.parseInt(input.readLine()), sum=N, in=N, i;
		for (i=0; sum<=P; in*=R, sum+=in, i++);
		System.out.println(i);
	}

}
