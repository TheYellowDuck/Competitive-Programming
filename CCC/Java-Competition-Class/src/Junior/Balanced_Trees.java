package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Balanced_Trees {
	static HashMap<Integer, Long> map=new HashMap<Integer, Long>();
	static Long v;
	static long sum;
	static int n;
	public static long trees(int W) {
		sum=0;
		for (int i=W; i>1; i--) {
			n=W/i;
			v=map.get(n);
			if (v==null) sum+=trees(n);
			else sum+=v;
		}
		map.put(W, sum);
		return sum;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int W=Integer.parseInt(input.readLine());
        map.put(1, (long) 1);
        if (W!=1) System.out.println(trees(W));
        else System.out.println(1);
	}

}