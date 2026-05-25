package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Squares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("The largest square has side length "+(int) Math.floor(Math.sqrt((int) Double.parseDouble(input.readLine())))+".");
	}

}
