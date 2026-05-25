package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CCC_00_J2 {
	static ArrayList<Integer> rable=new ArrayList<Integer>(Arrays.asList(0, 1, 6, 8, 9));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int start=(int) Double.parseDouble(input.readLine());
		int end=(int) Double.parseDouble(input.readLine());
		int count=0;
		for (int i=start; i<=end; i++) {
			if (valid(String.valueOf(i).toCharArray())==1) {
				count+=reverse(String.valueOf(i).toCharArray());
			}
		}
		System.out.println(count);
	}
	public static int valid(char[] x) {
		for (int i=0; i<x.length; i++) {
			if (!rable.contains(x[i]-'0')) {
				return 0;
			}
		}
		return 1;
	}
	public static int reverse(char[] x) {
		char[] array=x.clone();
		for (int i=0, j=x.length; i<x.length/2; i++, j--) {
			switch (x[i]-'0') {
			case 6:
				array[i]='9';
				break;
			case 9:
				array[i]='6';
				break;
			}
		}
		for (int i=0; i<array.length/2; i++) { 
			char temp=array[i]; 
			array[i]=array[array.length-i-1]; 
			array[array.length-i-1]=temp; 
		}
		if (Arrays.equals(array, x))
			return 1;
		return 0;
	}
}
