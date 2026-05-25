package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Substrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		for (int i=0; i<n; i++) {
			String str=input.readLine();
			Map<String, Integer> count=new HashMap<String, Integer>();
			for (int j=0; j<str.length(); j++)
				for (int m=j+1; m<=str.length(); m++)
					count.put(str.substring(j, m), 0);
			System.out.println(count.size()+1);
		}
	}
	
}
