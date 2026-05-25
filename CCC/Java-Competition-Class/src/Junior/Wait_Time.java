package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Wait_Time {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int[] array=new int[100];
		int[] wait=new int[100];
		SortedSet<Integer> list=new TreeSet<Integer>();
		Arrays.fill(array, -1);
		int l=Integer.parseInt(input.readLine());
		for (int i=0, s=0; i<l; i++, s++) {
			String[] in=input.readLine().split(" ");
			int x=Integer.parseInt(in[1]);
			switch(in[0]) {
			case "R":
				array[x-1]=s;
				list.add(x-1);
				break;
			case "S":
				wait[x-1]+=s-array[x-1];
				array[x-1]=-2;
				break;
			case "W":
				s+=x-2;
				break;
			}
		}
		for (int i:list) {
			if (array[i]==-2)
				System.out.println((i+1)+" "+wait[i]);
			else if (array[i]!=-1)
				System.out.println((i+1)+" -1");
		}
	}

}
