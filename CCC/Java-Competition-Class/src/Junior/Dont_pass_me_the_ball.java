package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dont_pass_me_the_ball {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());

		if (num < 4)
			System.out.print(0);
		else
			System.out.print((num - 1) * (num - 2) * (num - 3) / 6);
	}

}