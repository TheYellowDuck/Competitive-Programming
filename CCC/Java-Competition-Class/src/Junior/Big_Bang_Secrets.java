package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Big_Bang_Secrets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int k=(int) Double.parseDouble(input.readLine());
		char[] str=input.readLine().toCharArray();
		for (int i=0; i<str.length; i++) {
			char letter=(char) (str[i]-((3*(i+1))+k));
			if (letter<65)
				letter+=26;
			System.out.print(letter);
		}
	}

}
