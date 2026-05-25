package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boolean {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int t=s.length-1;
		String v=s[t], tr="True", f="False";
		System.out.println(t%2==0?(v.contentEquals(tr)?tr:f):(v.contentEquals(f)?tr:f));

	}

}
