package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Do_the_Shuffle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> array=new ArrayList<Character>() {{
			add('A');
			add('B');
			add('C');
			add('D');
			add('E');
		}};
		int b=(int) Double.parseDouble(input.readLine());
		int n=(int) Double.parseDouble(input.readLine());
		while (b!=4) {
			switch (b) {
			case 1:
				for (int i=0; i<n; i++) {
					array.add(array.get(0));
					array.remove(0);
				}
				break;
			case 2:
				for (int i=0; i<n; i++) {
					array.add(0, array.get(4));
					array.remove(5);
				}
				break;
			case 3:
				for (int i=0; i<n; i++) {
					array.add(0, array.get(1));
					array.remove(2);
				}
				break;
			}
			b=(int) Double.parseDouble(input.readLine());
			n=(int) Double.parseDouble(input.readLine());
		}
		System.out.println(Arrays.toString(array.toArray()).replace(",", "").replace("[", "").replace("]", ""));
	}

}
