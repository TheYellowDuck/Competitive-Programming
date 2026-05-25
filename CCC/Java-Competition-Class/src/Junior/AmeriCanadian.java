package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AmeriCanadian {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String x = input.readLine();
		ArrayList<String> array = new ArrayList<String>();
		String vowels = "aeiouy";
		while (!x.contentEquals("quit!")) {
			if (x.length() > 4 && x.substring(x.length() - 2).contentEquals("or")
					&& !vowels.contains(x.substring(x.length() - 3, x.length() - 2)))
				array.add(x.substring(0, x.length() - 2) + "our");
			else
				array.add(x);
			x = input.readLine();
		}
		for (String i : array) {
			System.out.println(i);
		}
	}

}
