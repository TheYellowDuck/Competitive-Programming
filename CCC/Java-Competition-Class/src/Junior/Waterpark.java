package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Waterpark {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Integer>> connected=new HashMap<Integer, ArrayList<Integer>>();
		int p=Integer.parseInt(input.readLine()), bool=0;
		int[] ppl=new int[p];
		double a=System.currentTimeMillis();long bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		String line=input.readLine();
		if (!line.contentEquals("0 0"))
			bool=1;
		while (!line.contentEquals("0 0")) {
			String[] in=line.split(" ");
			int f=Integer.parseInt(in[0]), g=Integer.parseInt(in[1]);
			ArrayList<Integer> c;
			if (connected.get(f)==null) c=new ArrayList<Integer>();
			else c=connected.get(f);
			c.add(g);
			connected.put(f, c);
			line=input.readLine();
		}
		if (bool==1) {
			ppl[p-1]=1;
			for (int i=p-1; i>0; i--) for (int j:connected.get(i)) ppl[i-1]+=ppl[j-1];
		}
		System.out.println(ppl[0]);
		System.out.println((System.currentTimeMillis()-a)+"\n"+(((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM)/1000000));
	}

}
