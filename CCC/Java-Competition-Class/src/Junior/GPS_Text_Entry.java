package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GPS_Text_Entry {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char[][] array=new char[][] {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P', 'Q', 'R'}, {'S', 'T', 'U', 'V', 'W', 'X'}, {'Y', 'Z', ' ', '-', '.', '0'}};
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] str=input.readLine().concat("0").toCharArray();
		int x=0;
		int y=0;
		int steps=0;
		for (int i=0; i<str.length; i++) {
			for (int n=0; n<array.length; n++) {
				for (int m=0; m<array[n].length; m++) {
					if (array[n][m]==str[i]) {
						steps+=Math.abs(n-x)+Math.abs(m-y);
						x=n;
						y=m;
					}
				}
			}
		}
		System.out.println(steps);
	}

}
