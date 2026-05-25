package Built_in_Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class CCC_15_S3_Gates {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()), T = Integer.parseInt(br.readLine()), c = 0;
		TreeSet<Integer> gates = new TreeSet<Integer>();
		while (G > 0) {
			gates.add(G);
			G--;
		}
		while (T > 0) {
			int i = Integer.parseInt(br.readLine());
			Integer val = gates.floor(i);
			if (val != null) {
				gates.remove(val);
				c++;
			}
			else break;
			T--;
		}
		System.out.println(c);
	}

}
