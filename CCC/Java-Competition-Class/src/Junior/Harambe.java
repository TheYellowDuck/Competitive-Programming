package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Harambe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] in=input.readLine().toCharArray(); 
		input.close();
		int leng=in.length, count=0;
		char[] l=new char[leng], c=new char[leng];
		char v;
		for (int i=0; i<leng; i++) {
			v=in[i];
			if (v!=32) {
				if (v<91) {
					count++;
					c[i]=v;
					l[i]=(char) (v+32);
				}
				else {
					count--;
					l[i]=v;
					c[i]=(char) (v-32);
				}
			}
			else {
				l[i]=v;
				c[i]=v;
			}
		}
		if (count<0) System.out.println(l);
		else if (count>0) System.out.println(c);
		else System.out.println(in);
	}

}
