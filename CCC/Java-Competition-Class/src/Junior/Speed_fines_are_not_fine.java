package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Speed_fines_are_not_fine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=(int) Double.parseDouble(input.readLine());
		int s=(int) Double.parseDouble(input.readLine());
		System.out.println(s>=l+1?s>=l+21?s>=l+31?"You are speeding and your fine is $500.":"You are speeding and your fine is $270.":"You are speeding and your fine is $100.":"Congratulations, you are within the speed limit!");
	}

}
