package Fun_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Prime_Time {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t ++) {
			TreeMap<Integer, Long> mp = new TreeMap<>(Collections.reverseOrder());
			HashMap<Integer, Long> c = new HashMap<>();
			int l = Integer.parseInt(br.readLine());
			long s = 0;
			while (l -- > 0) {
				String[] in = br.readLine().split(" ");
				int p = Integer.parseInt(in[0]);
				long n = Long.parseLong(in[1]);
				s += p * n;
				c.put(p, n);
				
			}
			for (Entry<Integer, Long> i : c.entrySet()) 
				mp.put(i.getKey(), s - i.getValue());
			for (int p : mp.keySet()) {
				
			}
		}

	}

}
