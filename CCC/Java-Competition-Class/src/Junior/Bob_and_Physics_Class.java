package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bob_and_Physics_Class {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ", 2);
		int l=Integer.parseInt(in[0]), max=Integer.parseInt(in[1]), count=0, a, b;
		ArrayList<char[]> out=new ArrayList<char[]>();
		char[] outer;
		ArrayList<Integer> nums=new ArrayList<Integer>(), sortednums;
		in=input.readLine().split(" ", l);
		input.close();
		for (int i=0; i<l; i++) nums.add(Integer.parseInt(in[i]));
		ArrayList<Integer> compare=new ArrayList<Integer>(nums);
		Collections.sort(compare);
		if (nums.equals(compare)) {
			System.out.println(0);
			return;
		}
		while (count<max) {
			outer=new char[l-1];
			sortednums=new ArrayList<Integer>();
			sortednums.add(nums.get(0));
			for (int i=1; i<l; i++) {
				a=sortednums.get(sortednums.size()-1);
				b=nums.get(i);
				if (b>=a) {
					sortednums.add(b);
					outer[i-1]='B';
				}
				else {
					sortednums.add(0, b);
					outer[i-1]='T';
				}
			}
			nums=sortednums;
			out.add(outer);
			count++;
			if (nums.equals(compare))
				break;
		}
		System.out.println(count);
		for (int i=0; i<out.size(); i++) System.out.println(String.valueOf(out.get(i)));
		System.out.println(nums);
	}
}
