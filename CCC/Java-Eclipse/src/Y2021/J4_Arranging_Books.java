package Y2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J4_Arranging_Books {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		ArrayList<Integer> list = new ArrayList<>();
		int c = 0, l = 0, m = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 'L') {
				list.add(i);
				l++;
			}
			else if (a[i] == 'M') 
				m++;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < l) {
				list.remove(i);
				i--;
			}
			else break;
		}
		for (int i = 0; i < l; i++) {
			if (a[i] != 'L') {
				if (a[i] == 'M') {
					a[i] = 'L';
					a[list.get(0)] = 'M';
					list.remove(0);
				}
				else {
					a[i] = 'L';
					a[list.get(list.size() - 1)] = 'S';
					list.remove(list.size() - 1);
				}
				c++;
			}
		}
		for (int i = l + m; i < a.length; i++) 
			if (a[i] == 'M') c++;
		System.out.println(c);
	}

}
