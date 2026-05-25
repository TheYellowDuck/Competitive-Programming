package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hidden_Palindrome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String str=input.readLine();
		for (int i=str.length(); i>0; i--) {
			for (int j=0, ii=i; ii<=str.length(); ii++, j++) {
				String reversed=new StringBuilder(str.substring(j, ii)).reverse().toString();
				if (str.substring(j, ii).contentEquals(reversed)) {
					System.out.println(ii-j);
					return;
				}
			}
		}
	}

}
