package Built_in_Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class MWC_15_4_P3_Salt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Long> mp = new HashSet<>();
		HashMap<Integer, Integer> X = new HashMap<>(), Y = new HashMap<>();
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), Q = Integer.parseInt(in[1]);
		while (N > 0) {
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]);
			mp.add((((long) x) << 32) + y);
			X.put(x, X.getOrDefault(x, 0) + 1);
			Y.put(y, Y.getOrDefault(y, 0) + 1);
			N--;
		}
		while (Q > 0) {
			in = br.readLine().split(" ");
			switch(in[0]) {
			case "1" :
				System.out.println(mp.contains((Long.parseLong(in[1]) << 32) + Integer.parseInt(in[2])) ? "salty" : "bland");
				break;
			case "2" :
				switch(in[1]) {
				case "X" :
					System.out.println(X.getOrDefault(Integer.parseInt(in[2]), 0));
					break;
				case "Y" :
					System.out.println(Y.getOrDefault(Integer.parseInt(in[2]), 0));
					break;
				}
				break;
			}
			Q--;
		}

	}

}
