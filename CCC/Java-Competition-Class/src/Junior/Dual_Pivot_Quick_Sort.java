package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dual_Pivot_Quick_Sort {

	public static int[] quick(int[] array, int l, int h) {
		int p=l, p2=h, v=array[p], v2=array[p2], v3;
		if (v>v2) {
			array[p]=array[p2];
			array[p2]=v;
			v=v2;
			v2=array[p2];
		}
		for (int i=l+1; i<p2; i++) {
			v3=array[i];
			if (v3<v) {
				for (int j=i; j>p; j--) array[j]=array[j-1];
				array[p]=v3;
				p++;
			}
			else if (v3>v2) {
				for (int j=i; j<p2; j++) array[j]=array[j+1];
				array[p2]=v3;
				p2--;
				i--;
			}
			
		}
		if (l<p-1)
			array=quick(array, l, p-1);
		if (p+1<p2-1)
			array=quick(array, p+1, p2-1);
		if (p2+1<h)
			array=quick(array, p2+1, h);
		return array;
		
	}

	public static void main(int[] array) throws IOException {
		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		String[] in = input.readLine().split(" ");
//		int l = in.length;
//		int[] array = new int[l];
//		for (int i = 0; i < l; i++)
//			array[i] = Integer.parseInt(in[i]);
		array=quick(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

	}

}
