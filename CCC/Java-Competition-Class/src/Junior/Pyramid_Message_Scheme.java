package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Pyramid_Message_Scheme {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> names = new ArrayList<String>(), vs = new ArrayList<String>();
		int l = Integer.parseInt(input.readLine()), n, max;
		String name;
		for (; l > 0; l--) {
			max = 0;
			map.clear();
			names.clear();
			vs.clear();
			n = Integer.parseInt(input.readLine());
			name = input.readLine();
			map.put(name, 1);
			names.add(name);
			vs.add(name);
			for (int i = 1; i < n - 1; i++) {
				name = input.readLine();
				if (names.contains(name)) {
					vs.remove(max);
					max--;
				} else {
					map.put(name, map.get(vs.get(max)) + 1);
					vs.add(name);
					if (!names.contains(name))
						names.add(name);
					max++;
				}
			}
			name = input.readLine();
			for (int i = 0; i < names.size(); i++)
				if (names.get(i).contentEquals(name)) {
					max = map.get(name);
					for (; i < names.size(); i++) {
						name = names.get(i);
						map.replace(name, map.get(name) - max);
					}
				}
			max = Integer.MIN_VALUE;
			for (int i : map.values())
				if (i > max)
					max = i;
			System.out.println((n * 10) - (max * 2 * 10));
		}
	}
}