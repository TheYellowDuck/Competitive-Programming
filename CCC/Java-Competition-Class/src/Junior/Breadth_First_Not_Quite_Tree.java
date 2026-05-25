package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Breadth_First_Not_Quite_Tree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Integer> v=new HashMap<Integer, Integer>();
		ArrayList<Integer> value, f, nf, s;
		String[] in;
		int q, a, b, c, bool;
		for (int i=0; i<5; i++) {
			c=0;
			map.clear();
			v.clear();
			q=Integer.parseInt(input.readLine());
			for (; q>0; q--) {
				in=input.readLine().split(" ");
				a=Integer.parseInt(in[0]);
				b=Integer.parseInt(in[1]);
				value=map.getOrDefault(a, new ArrayList<Integer>());
				value.add(b);
				map.put(a, value);
				value=map.getOrDefault(b, new ArrayList<Integer>());
				value.add(a);
				map.put(b, value);
			}
			f=new ArrayList<Integer>();
			f.addAll(map.get(1));
			v.put(1, 0);
			for (int j:f) v.put(j, 0);
			while (!f.isEmpty()) {
				nf=new ArrayList<Integer>();
				for (int j=0; j<f.size()-1; j++) {
					s=map.get(f.get(j));
					for (int n=j+1; n<f.size(); n++) {
						bool=0;
						for (int m:s) {
							if (v.get(m)==null) {
								nf.add(m);
								v.put(m, 0);
							}
							if (bool==0 && m==f.get(n)) bool=1;
						}
						if (bool==1) c++;
					}
				}
				s=map.get(f.get(f.size()-1));
				for (int j:s)
					if (v.get(j)==null) {
						nf.add(j);
						v.put(j, 0);
					}
				f=nf;
			}
			System.out.println(c);
		}
		
	}

}