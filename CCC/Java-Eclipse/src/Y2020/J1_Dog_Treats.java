package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1_Dog_Treats {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		if (Integer.parseInt(input.readLine()) + 2 * Integer.parseInt(input.readLine()) + 3 * Integer.parseInt(input.readLine()) > 9) 
			System.out.println("happy");
		else
			System.out.println("sad");
	}

}
