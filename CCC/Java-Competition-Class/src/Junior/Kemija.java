package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kemija {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] in=input.readLine().toCharArray();
		for (int i=0; i<in.length; i++) {
			System.out.print(in[i]);
			if (in[i]=='a' || in[i]=='e' || in[i]=='i' || in[i]=='o' || in[i]=='u') i+=2;
		}
	}

}
