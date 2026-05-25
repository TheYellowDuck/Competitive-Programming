package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Cogwheels {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> f, nf, n, lf=new ArrayList<Integer>(), lnf=new ArrayList<Integer>();
		int[] direction;
		String[] in;
		int x, a, b, bool;
		for (int i=0; i<5; i++) {
			bool=0;
			map.clear();
			in=input.readLine().split(" ");
			direction=new int[Integer.parseInt(in[0])];
			x=Integer.parseInt(in[1]);
			for (int j=0; j<x; j++) {
				in=input.readLine().split(" ");
				a=Integer.parseInt(in[0])-1;
				b=Integer.parseInt(in[1])-1;
				f=new ArrayList<Integer>(map.getOrDefault(a, new ArrayList<Integer>()));
				f.add(b);
				map.put(a, f);
				f=new ArrayList<Integer>(map.getOrDefault(b, new ArrayList<Integer>()));
				f.add(a);
				map.put(b, f);
			}
			f=new ArrayList<Integer>();
			f.add(0);
			a=2;
			while (!f.isEmpty() && bool==0) {
				nf=new ArrayList<Integer>();
				for (int j=0; j<f.size() && bool==0; j++) {
					n=new ArrayList<Integer>(map.get(f.get(j)));
					for (int m:n) {
						b=direction[m];
						if (b==0) {
							nf.add(m);
							direction[m]=a;
						}
						else {
							if (a!=b) {
								System.out.println("LL");
								bool=1;
								break;
							}
						}
					}
				}
				a=a==1?2:1;
				f=nf;
			}
			if (bool==0) {
				a=direction[1];
				b=direction[2];
				System.out.println((a==1?"A":"B")+(b==1?"A":"B"));
			}
		}
	}

}

