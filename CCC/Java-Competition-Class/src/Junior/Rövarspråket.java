package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Rövarspråket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] in=input.readLine().toCharArray();
		char[] vs=new char[] {'u', 'o', 'i', 'e', 'a'};
		String str="";
		for (int i=0; i<in.length; i++) {
			if (in[i]!='a' && in[i]!='e' && in[i]!='i' && in[i]!='o' && in[i]!='u') {
				str=str.concat(String.valueOf(in[i]));
				int[] vowel=new int[] {Math.abs(in[i]-'u'), Math.abs(in[i]-'o'), Math.abs(in[i]-'i'), Math.abs(in[i]-'e'), Math.abs(in[i]-'a')};
				Map<Integer, Character> v=new HashMap<Integer, Character>();
				v.put(vowel[0], 'u');
				for (int j=1; j<vowel.length; j++) {
					v.put(vowel[j], vs[j]);
		            int key=vowel[j]; 
		            int n=j-1; 
		            while (n>=0 && vowel[n]>key) { 
		                vowel[n+1]=vowel[n]; 
		                n=n-1; 
		            } 
		            vowel[n+1]=key; 
		        }
				str=str.concat(String.valueOf(v.get(vowel[0])));
				if (!v.containsValue((char)(in[i]+1)))
					str=str.concat(String.valueOf(in[i]<'z'?(char) (in[i]+1):'z'));
				else
					str=str.concat(String.valueOf(in[i]<'y'?(char) (in[i]+2):'z'));
			}
			else
				str=str.concat(String.valueOf(in[i]));
		}
		System.out.println(str);
	}

}
