package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class J4_S2_Good_Groups_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, HashSet<String>> Must = new HashMap<>(), MustNot = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		for (int i = 0; i < X; i ++) {
			String[] in = br.readLine().split(" ");
			HashSet<String> L = Must.getOrDefault(in[0], new HashSet<>());
			L.add(in[1]);
			Must.put(in[0], L);
		}
		int Y = Integer.parseInt(br.readLine());
		for (int i = 0; i < Y; i ++) {
			String[] in = br.readLine().split(" ");
			HashSet<String> L = MustNot.getOrDefault(in[0], new HashSet<>());
			L.add(in[1]);
			MustNot.put(in[0], L);
		}
		int G = Integer.parseInt(br.readLine());
		for (int i = 0; i < G; i ++) {
			String[] in = br.readLine().split(" ");
			for (int n = 0; n < 3; n ++) {
				for (int m = 0; m < 3; m ++) {
					if (Must.get(in[n]) != null && Must.get(in[n]).contains(in[m]))
						X --;
					if (MustNot.get(in[n]) != null && MustNot.get(in[n]).contains(in[m]))
						X ++;
				}
			}
		}
		System.out.println(X);
	}

}
