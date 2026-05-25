package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cold_Compress {
	public static void main(String[] args)throws NumberFormatException, IOException {
	    BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine());
		String[] array=new String[l];
		for (int c=0; c<l; c++) {
			String string="";
			String str=input.readLine().replace(" ", "").concat("0");
			int i=0, j=1;
			String sub=str.substring(i, j);
			for (; j<str.length(); j++) {
				if (str.charAt(i)==str.charAt(j))
					sub=str.substring(i, j+1);
				else {
					string=string.concat(sub.length()+" "+sub.charAt(0)+" ");
					i=j;
					if (j<str.length())
						sub=str.substring(i, i+1);
				}
			}
			array[c]=string.substring(0, string.length()-1);
		}
		for (String str:array) {
			System.out.println(str);
		}
	}
}
