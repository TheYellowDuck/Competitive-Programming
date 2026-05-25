package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Who_Has_Seen_The_Wind {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int h=(int) Double.parseDouble(input.readLine());
		int m=(int) Double.parseDouble(input.readLine());
		for (int t=1; t<=m; t++) {
			if ((-6*t*t*t*t)+(h*t*t*t)+(2*t*t)+t<=0) {
				System.out.println("The balloon first touches ground at hour:\n"+t);
				return;
			}
		}
		System.out.println("The balloon does not touch ground in the given time.");
	}

}
