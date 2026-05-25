package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Time_to_Decompress {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(input.readLine()), n;
		String str;
		String[] in;
		for (int i=0; i<t; i++) {
			in=input.readLine().split(" ");
			n=Integer.parseInt(in[0]);
			str=in[1];
			for (int j=0; j<n; j++) System.out.print(str);
			System.out.println();
		}

	}

}
