package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Body_Mass_Index {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		double w=Double.parseDouble(input.readLine());
		double h=Double.parseDouble(input.readLine());
		if (w/(h*h)>25) 
			System.out.println("Overweight");
		else if (w/(h*h)<18.5) 
			System.out.println("Underweight");
		else
			System.out.println("Normal weight");
	}

}
