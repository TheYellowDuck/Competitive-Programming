package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Redirection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int s=Integer.parseInt(input.readLine()), m, index=0;
		int[] str=new int[s];
		for (int i=0; i<s; i++) str[i]=input.readLine().length();
		s=Integer.parseInt(input.readLine());
		int[] cs=new int[s];
		for (int i:str) {
			m=Integer.MAX_VALUE;
			for (int j=0; j<s; j++) 
				if (cs[j]<m) {
					index=j;
					m=cs[j];
				}
			cs[index]+=i;
			System.out.println(index+1);
		}

	}

}

