package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Range_Updates_and_Range_Queries {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ");
		int[] array=new int[Integer.parseInt(in[0])];
		int Q=Integer.parseInt(in[1]), l, r, a;
		for (; Q>0; Q--) {
			in=input.readLine().split(" ");
			switch (in[0]) {
			case "1":
				l=Integer.parseInt(in[1]);
				r=Integer.parseInt(in[2]);
				a=Integer.parseInt(in[3]);
				for (int i=l-1; i<r; i++) array[i]+=a*(i+2-l);
				break;
			case "2":
				l=Integer.parseInt(in[1])-1;
				r=Integer.parseInt(in[2]);
				a=0;
				for (; l<r; l++) a+=array[l];
				System.out.println(a);
				break;
			}
		}

	}

}
