package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1_Boiling_Water {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int o = Integer.parseInt(br.readLine()), p = o * 5 - 400;
		System.out.println(p + "\n" + (o < p ? -1 : o > p ? 1 : 0));

	}

}
