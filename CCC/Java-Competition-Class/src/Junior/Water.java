package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Water {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), y=Math.abs(x-Integer.parseInt(input.readLine())), z=Math.abs(x-Integer.parseInt(input.readLine()));
		System.out.println(Integer.max(y, z));

	}

}
