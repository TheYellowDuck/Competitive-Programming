package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exactly_Electrical {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" "), in2=input.readLine().split(" ");
		int e=Integer.parseInt(input.readLine()), sx=Integer.parseInt(in[0]), sy=Integer.parseInt(in[1]), ex=Integer.parseInt(in2[0]), ey=Integer.parseInt(in2[1]);
		List<Integer> xa=new ArrayList<Integer>(), ya=new ArrayList<Integer>();
		xa.add(sx);
		ya.add(sy);
		for (int i=0; i<e; i++) {
			List<Integer> xa1=new ArrayList<Integer>(), ya1=new ArrayList<Integer>();
			for (int j=0; j<xa.size(); j++) {
				xa1.add(xa.get(j)+1); ya1.add(ya.get(j));
				xa1.add(xa.get(j)-1); ya1.add(ya.get(j));
				xa1.add(xa.get(j)); ya1.add(ya.get(j)+1);
				xa1.add(xa.get(j)); ya1.add(ya.get(j)-1);
			}
			xa=xa1; ya=ya1;
		}
		for (int i=0; i<xa.size(); i++) {
			if (xa.get(i)==ex && ya.get(i)==ey) {
				System.out.println("Y");
				return;
			}
		}
		System.out.println("N");
	}

}
