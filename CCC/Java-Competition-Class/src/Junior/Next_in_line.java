package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Next_in_line {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=(int) Double.parseDouble(input.readLine()), b=(int) Double.parseDouble(input.readLine());
		System.out.println(b+(b-a));
	}

}
