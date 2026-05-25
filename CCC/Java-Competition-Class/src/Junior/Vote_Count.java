package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vote_Count {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), c=0;
		char[] str=input.readLine().toCharArray();
		for (char s:str) {
			switch (s) {
			case 'A':
				c++;
				break;
			case 'B':
				c--;
				break;
			}
		}
		System.out.println(c<0?"B":c==0?"Tie":"A");
	}

}
