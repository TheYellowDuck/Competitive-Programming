package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Friends {
	
	static HashMap<Integer, Integer> group=new HashMap<Integer, Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int ppl=Integer.parseInt(input.readLine());
		for (int i=0; i<ppl; i++) {
			String[] in=input.readLine().split(" ");
			group.put(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
		}
		String line=input.readLine();
		while (!line.contentEquals("0 0")) {
			String[] in=line.split(" ");
			int a=Integer.parseInt(in[0]), x=Integer.parseInt(in[0]), y=Integer.parseInt(in[1]), bool=0;
			for (int i=0; bool==0; i++) {
				if (group.get(x)!=null) {
					int v=group.get(x);
					if (v==y) {
						System.out.println("Yes "+i);
						bool=1;
					}
					else if (v==a)
						bool=2;
					else x=v;
				}
				else bool=2;
			}
			if (bool==0 || bool==2)
				System.out.println("No");
			line=input.readLine();
		}
	}

}
