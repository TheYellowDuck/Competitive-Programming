package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Canadian_Calorie_Counting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> choices=new HashMap<Integer, Integer>() {{
				put(1, 461);
				put(2, 431);
				put(3, 420);
				put(4, 0);
				put(5, 100);
				put(6, 57);
				put(7, 70);
				put(8, 0);
				put(9, 130);
				put(10, 160);
				put(11, 118);
				put(12, 0);
				put(13, 167);
				put(14, 266);
				put(15, 75);
				put(16, 0);
		}};
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int total=0;
		total+=choices.get((int) Double.parseDouble(input.readLine()));
		total+=choices.get((int) Double.parseDouble(input.readLine())+4);
		total+=choices.get((int) Double.parseDouble(input.readLine())+8);
		total+=choices.get((int) Double.parseDouble(input.readLine())+12);
		System.out.println("Your total Calorie count is "+total+".");
	}

}
