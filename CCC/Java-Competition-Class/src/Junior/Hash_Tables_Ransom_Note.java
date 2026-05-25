package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hash_Tables_Ransom_Note {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, Integer> M=new HashMap<String, Integer>();
		HashMap<String, Integer> N=new HashMap<String, Integer>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] str=input.readLine().split(" ");
		String[] mag=input.readLine().split(" ");
		String[] not=input.readLine().split(" ");
		int m=Integer.parseInt(str[0]), n=Integer.parseInt(str[1]);
		for (int i=0; i<m; i++) {
			if (M.get(mag[i])==null)
				M.put(mag[i], 1);
			else
				M.put(mag[i], M.get(mag[i])+1);
		}
		for (int i=0; i<n; i++) {
			if (N.get(not[i])==null)
				N.put(not[i], 1);
			else
				N.put(not[i], N.get(not[i])+1);
		}
		for (int i=0; i<n; i++) {
			Integer numn=N.get(not[i]);
			Integer numm=M.get(not[i]);
			numm=numm==null?0:numm;
			if (numm<numn) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}
