package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Its_Cold_Here {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String city="";
		int temp=Integer.MAX_VALUE;
		String ic;
		int it;
		do {
			String[] str=input.readLine().split(" ");
			ic=str[0];
			it=(int) Double.parseDouble(str[1]);
			if (it<temp) {
				city=ic;
				temp=it;
			}
		}
		while (!ic.contentEquals("Waterloo"));
		System.out.println(city);
	}

}
