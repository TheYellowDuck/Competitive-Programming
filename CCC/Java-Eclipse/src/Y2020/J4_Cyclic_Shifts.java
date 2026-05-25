package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J4_Cyclic_Shifts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = input.readLine().toCharArray(), s2 = input.readLine().toCharArray();
		if (s2.length > s1.length) {
			System.out.println("no");
			System.exit(0);
		}
		for (int i = 0; i < s2.length; i++) {
			for (int j = 0; j < s1.length - s2.length + 1; j++) {
				int cur = i;
				boolean works = true;
				for (int k = 0; k < s2.length; k++) {
					if (s2[cur] != s1[j + k]) {
						works = false;
						break;
					}
					cur++;
					cur %= s2.length;
				}
				if (works) {
					System.out.println("yes");
					System.exit(0);
				}
			}
		}
		System.out.println("no");
	}

}
