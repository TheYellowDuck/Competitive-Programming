package Y2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S1_Ragaman {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> mp = new HashMap<>();
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		boolean isAnagram = false;
		if (s1.length == s2.length) {
			int tt1 = s1.length;
			int wc1 = 0;
			int tt2 = s2.length;
			int wc2 = 0;
			for (char i : s1) {
				if (i == '*') {
					tt1 --;
					wc1 ++;
				}
				else 
					mp.put(i, mp.getOrDefault(i, 0) + 1);
			}
			for (char i : s2) {
				if (i == '*') {
					tt2 --;
					wc2 ++;
				}
				else {
					if (mp.getOrDefault(i, 0) - 1 >= 0) {
						mp.put(i, mp.getOrDefault(i, 0) - 1);
						tt1 --;
						tt2 --;
					}
				}
			}
			if (tt1 == wc2 && tt2 == wc1)
				isAnagram = true;
		}
		System.out.println(isAnagram ? "A" : "N");
	}

}
