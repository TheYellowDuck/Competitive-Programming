package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class dmopc15c4p4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]), Q = Integer.parseInt(in[2]);
		in = br.readLine().split(" ");
		int[] psa = new int[N];
		psa[0] = Integer.parseInt(in[0]);
		mp.put(psa[0], new HashSet<>());
		mp.get(psa[0]).add(0);
		for (int i = 1; i < N; i ++)  {
			int v = Integer.parseInt(in[i]);
			psa[i] = psa[i - 1] + v;
			mp.put(v, mp.getOrDefault(v, new HashSet<>()));
			mp.get(v).add(i);
		}
		for (int i = 0; i < Q; i ++) {
			in = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]), x = Integer.parseInt(in[2]), y = Integer.parseInt(in[3]);
			if (psa[y] - psa[x] > K) {
				if (mp.get(a))
			}
		}
	}

}
