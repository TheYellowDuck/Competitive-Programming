package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_Good_Fours_and_Good_Fives_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), C = 0;
		for (int i = N / 4; i >= 0; i --) {
			if ((N - i * 4) % 5 == 0)
				C ++;
		}
		System.out.println(C);
	}

}
