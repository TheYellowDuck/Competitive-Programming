package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourD_BBST_on_a_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine()), f=256, e=0;
		char[] array=input.readLine().toCharArray();
		String str="";
		for (int i=0; i<l; i++) {
			if (array[i]<=f) {
				str=String.valueOf(array[i]).concat(str);
				f=array[i];
			}
			else {
				str=str.concat(String.valueOf(array[i]));
				e=array[i];
			}
		}
		System.out.println(str);
	}

}
