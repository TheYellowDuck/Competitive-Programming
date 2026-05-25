package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ECOO_18_R2_P3_Factorial {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 0; T < 10; T ++) {
			String[] in = br.readLine().split(" ");
			int K = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]), KM = K * M;
			for (int i = 2; i < KM; i ++) {
				if (KM % i == 0) {
					M -= KM / i;
					KM /= i;
				}
				if (M <= 0) {
					System.out.println(i);
					break;
				}
			}
		}

	}

}
