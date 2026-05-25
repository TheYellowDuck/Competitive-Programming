package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Two_Strings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] s1=input.readLine().toCharArray();
		char[] s2=input.readLine().toCharArray();
		for (char i:s1) {
			if (map.get(i)==null)
				map.put(i, 1);
		}
		for (char i:s2) {
			if (map.get(i)!=null) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
