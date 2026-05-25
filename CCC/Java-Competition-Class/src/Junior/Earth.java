package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Earth {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ");
		int x=Integer.parseInt(in[0]), y=Integer.parseInt(in[1]);
		in=input.readLine().split(" ");
		if ((Integer.parseInt(in[0])<x && x<Integer.parseInt(in[2])) && (Integer.parseInt(in[1])<y && y<Integer.parseInt(in[3]))) 
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
