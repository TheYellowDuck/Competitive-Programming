package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_Good_Fours_and_Good_Fives {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		int[] A = new int[N];
//		if (N < 4)
//			System.out.println(0);
//		else {
//			A[4]
//		}
//		if (N % 20 == 0 || N % 20 % 4 == 0 || N % 20 % 5 == 0 || N % 20 % 5 % 4 == 0 || N % 20 % 4 % 5 == 0)
//			System.out.println(1 + N / 20);
//		else {
//			if (N % 4 == 0 || N % 5 == 0 || N % 5 % 4 == 0 || N % 4 % 5 == 0)
//				System.out.println(1);
//			else System.out.println(0);
//		}
		int count = 0;
		if (N % 4 == 0 || N % 5 == 0 || N % 5 % 4 == 0 || N % 4 % 5 == 0)
			count ++;
		if (N % 20 == 0 || N % 20 % 4 == 0 || N % 20 % 5 == 0)
			count = 2 * N / 20 - 1;
		System.out.println(count);
	}

}
