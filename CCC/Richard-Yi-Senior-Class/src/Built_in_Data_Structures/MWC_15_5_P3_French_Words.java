package Built_in_Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class MWC_15_5_P3_French_Words {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		HashSet<String> set = new HashSet<String>(Arrays.asList(br.readLine().split(" ")));
		String[] in = br.readLine().split(" ");
		int c = 0;
		for (String i : in) 
			if (set.contains(i)) {
				set.remove(i);
				c++;
			}
		System.out.println(c);
	}

}
