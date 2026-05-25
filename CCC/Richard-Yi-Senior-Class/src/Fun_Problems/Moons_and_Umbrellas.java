package Fun_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moons_and_Umbrellas {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]), cost = 0;
			char[] a = in[2].toCharArray();
			
			for (int i = 1; i < a.length; i++) {
				if (a[i] == '?') 
					a[i] = a[i - 1];
			}
			if (a[a.length - 1] == '?') 
				System.out.println("Case #" + t + ": 0");
			else {
				for (int i = a.length - 2; i >= 0; i--) {
					if (a[i] == '?') 
						a[i] = a[i + 1];
					if (a[i] == 'C' && a[i + 1] == 'J')
						cost += x;
					else if (a[i] == 'J' && a[i + 1] == 'C') cost += y;
				}
				System.out.println("Case #" + t + ": " + cost);
			}
		}
		
	}

}
