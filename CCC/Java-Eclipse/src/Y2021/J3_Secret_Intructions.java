package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J3_Secret_Intructions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int intruction = Integer.parseInt(br.readLine());
		String prev = "";
		while (intruction != 99999) {
			int d = intruction / 10000 + intruction / 1000;
			prev = d % 2 == 0 ? (d == 0 ? prev : "right ") : "left ";
			System.out.println(prev + (intruction % 1000));
			intruction = Integer.parseInt(br.readLine());
		}

	}

}
