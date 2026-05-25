package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ski_Rentals {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ", 3), in2;
		ArrayList<Integer> S=new ArrayList<Integer>(), K=new ArrayList<Integer>(), I=new ArrayList<Integer>();
		in2=input.readLine().split(" ", Integer.parseInt(in[0]));
		for (String i:in2) S.add(Integer.parseInt(i));
		in2=input.readLine().split(" ", Integer.parseInt(in[1]));
		for (String i:in2) K.add(Integer.parseInt(i));
		in2=input.readLine().split(" ", Integer.parseInt(in[2]));
		for (String i:in2) I.add(Integer.parseInt(i));
		int bool=0, v;
		for (int i=1; bool==0; i++) {
			v=S.get(0);
			v=v==0?S.remove(0):S.set(0, S.get(0)-1);
			v=K.get(0);
			v=v==0?K.remove(0):K.set(0, K.get(0)-1);
			v=I.get(0);
			v=v==0?I.remove(0):I.set(0, I.get(0)-1);
			if (i%30==0) {
				if (S.size()>K.size() && K.size()>I.size()) {
					I.add(S.get(S.size()-1));
					S.remove(S.size()-1);
				}
				else if (K.size()>S.size() && S.size()>I.size()) {
					I.add(K.get(K.size()-1));
					K.remove(K.size()-1);
				}
				else if (S.size()>I.size() && I.size()>K.size()) {
					K.add(S.get(S.size()-1));
					S.remove(S.size()-1);
				}
				else if (I.size()>S.size() && S.size()>K.size()) {
					K.add(I.get(I.size()-1));
					I.remove(I.size()-1);
				}
				else if (K.size()>I.size() && I.size()>S.size()) {
					S.add(K.get(K.size()-1));
					K.remove(K.size()-1);
				}
			}
		}

	}

}
