package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bruno_and_Fibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] f=new int[500];
		f[0]=1;
		f[1]=1;
		f[2]=1;
		f[4]=1;
		f[7]=1;
		f[12]=1;
		f[20]=1;
		f[33]=1;
		f[54]=1;
		f[88]=1;
		f[143]=1;
		f[232]=1;
		f[376]=1;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(input.readLine());
		char[] dna=input.readLine().toCharArray();
		char v;
		int fb, b=0;
		for (int i=0; i<len; i++) {
			v=dna[i];
			fb=f[i];
			if ((v!='A' && fb==1) || (v=='A' && fb==0)) {
				b=1;
				break;
			}
		}
		System.out.println(b==0?"That's quite the observation!":"Bruno, GO TO SLEEP");

	}

}

