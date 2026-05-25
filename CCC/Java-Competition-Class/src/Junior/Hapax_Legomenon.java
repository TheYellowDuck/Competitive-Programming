package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hapax_Legomenon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		int t=Integer.parseInt(input.readLine()), c=0;
		String in;
		for (; t>0; t--) {
			in=input.readLine();
			map.put(in, map.getOrDefault(in, 0)+1);
		}
		for (int i:map.values()) if (i==1) c++;
		System.out.println(c);
	}

}
