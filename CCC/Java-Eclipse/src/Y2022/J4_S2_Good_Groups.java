package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class J4_S2_Good_Groups {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, HashSet<String>> must = new HashMap<>();
		HashMap<String, HashSet<String>> mustnot = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		for (int i = 0; i < X; i ++) {
			String[] in = br.readLine().split(" ");
			HashSet<String> L = must.getOrDefault(in[0], new HashSet<>());
			L.add(in[1]);
			must.put(in[0], L);
		}
		int Y = Integer.parseInt(br.readLine());
		for (int i = 0; i < Y; i ++) {
			String[] in = br.readLine().split(" ");
			HashSet<String> L = mustnot.getOrDefault(in[0], new HashSet<>());
			L.add(in[1]);
			mustnot.put(in[0], L);
		}
		int G = Integer.parseInt(br.readLine());
		for (int i = 0; i < G; i ++) {
			String[] in = br.readLine().split(" ");
			for (String j : in) {
				int c = contains(must.get(j), in);
				X -= c;
				c = contains(mustnot.get(j), in);
				if (mustnot.get(j) != null)
					Y -= mustnot.get(j).size() - c;
			}
			System.out.println(X + " " + Y);
		}
		System.out.println(X + Y);
	}
	
	public static int contains(HashSet<String> s, String[] in) {
		if (s == null)
			return 0;
		int c = 0;
		for (String i : in) {
			if (s.contains(i))
				c ++;
		}
		return c;
	}

}
