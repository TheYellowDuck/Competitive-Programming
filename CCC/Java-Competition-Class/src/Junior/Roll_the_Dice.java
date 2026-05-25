package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Roll_the_Dice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine());
		int m=(int) Double.parseDouble(input.readLine());
		int c=0;
		for (int i=1; i<=n; i++){
			for (int k=1; k<=m; k++){
				if (i+k==10) 
					c++;
			}
		}
		if (c==1)
			System.out.println("There is " + c +" way to get the sum 10.");
		else
			System.out.println("There are " + c +" ways to get the sum 10.");
	}
	
}
