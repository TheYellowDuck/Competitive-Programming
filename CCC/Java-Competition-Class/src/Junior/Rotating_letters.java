package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rotating_letters {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] str=input.readLine().toCharArray();
		for (char i:str) {
			if (i!='I' && i!='O' && i!='S' && i!='H' && i!='Z' && i!='X' && i!='N') {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
