package Y2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S4_Twenty_four {
	
	static int S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N > 0) {
			S = 0;
			ArrayList<Integer> L = new ArrayList<Integer>();
			L.add(Integer.parseInt(br.readLine()));
			L.add(Integer.parseInt(br.readLine()));
			L.add(Integer.parseInt(br.readLine()));
			L.add(Integer.parseInt(br.readLine()));
			recurse(L);
			System.out.println(S);
			N --;
		}
	}
	
	static void recurse(ArrayList<Integer> L) {
		if (L.size() == 1) {
			if (L.get(0) <= 24) S = Math.max(S, L.get(0));
			return;
		}
		ArrayList<Integer> NL = new ArrayList<>(L);
		for (int i = 0; i < NL.size(); i ++) {
			for (int j = i + 1; j < NL.size(); j ++) {
				int v1 = NL.get(i), v2 = NL.get(j);
				
				NL.remove(i);
				NL.remove(j - 1);
				NL.add(v1 + v2);
				recurse(NL);
				
				NL = new ArrayList<>(L);
				
				NL.remove(i);
				NL.remove(j - 1);
				NL.add(v1 - v2);
				recurse(NL);
				
				NL = new ArrayList<>(L);
				
				NL.remove(i);
				NL.remove(j - 1);
				NL.add(v2 - v1);
				recurse(NL);
				
				NL = new ArrayList<>(L);
				
				NL.remove(i);
				NL.remove(j - 1);
				NL.add(v1 * v2);
				recurse(NL);
				
				NL = new ArrayList<>(L);
				
				if (v2 != 0 && v1 % v2 == 0) {
					NL.remove(i);
					NL.remove(j - 1);
					NL.add(v1 / v2);
					recurse(NL);
					
					NL = new ArrayList<>(L);
				}
				
				if (v1 != 0 && v2 % v1 == 0) {
					NL.remove(i);
					NL.remove(j - 1);
					NL.add(v2 / v1);
					recurse(NL);
					
					NL = new ArrayList<>(L);
				}
			}
		}
	}

}
