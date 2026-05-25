package Y2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1_Winning_Score {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()) * 3 + Integer.parseInt(br.readLine()) * 2 + Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()) * 3 + Integer.parseInt(br.readLine()) * 2 + Integer.parseInt(br.readLine());
		System.out.println(a < b ? "B" : a > b ? "A" : "T");
	}

}
