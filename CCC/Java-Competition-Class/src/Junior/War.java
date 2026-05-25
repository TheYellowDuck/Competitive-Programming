package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class War {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine()), bool=0, count=0;
		String[] in=input.readLine().split(" ", l);
		String[] in2=input.readLine().split(" ", l);
		for (int i=0; i<l; i++) {
			if (bool==0 && in[i].contentEquals(in2[i])) {
				count++;
				bool=1;
			}
			else if (bool==1 && !in[i].contentEquals(in2[i])) bool=0;
		}
		System.out.println(count);
	}

}
