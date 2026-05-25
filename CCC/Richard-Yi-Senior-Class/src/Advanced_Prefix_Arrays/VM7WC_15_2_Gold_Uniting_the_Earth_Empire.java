package Advanced_Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class VM7WC_15_2_Gold_Uniting_the_Earth_Empire {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Long> mp = new HashMap<>();
		int HS = Integer.parseInt(br.readLine()), i = -1;
		long ans = 0;
		long[] S = new long[HS];
		
		while (HS -- > 0) {
			
			long H = Long.parseLong(br.readLine());
			
			while (i != -1) {
				
				if (S[i] > H) {
					ans ++;
					break;
				}
				
				ans += mp.getOrDefault(S[i], (long) 1);
				
				if (S[i] == H)
					mp.put(H, mp.getOrDefault(H, (long) 1) + 1);
				
				else
					mp.remove(S[i]);
				
				i --;
			}
			
			i ++;
			S[i] = H;
			
		}
		
		System.out.println(ans);

	}

}
