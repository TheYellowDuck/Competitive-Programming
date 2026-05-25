package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quick_Sort {
	
	public static int[] quick(int[] array, int l, int h) {
		int p=(int) (Math.random()*(h-l+1))+l, v=array[p], v2;
		array[p]=array[l];
		array[l]=v;
		p=l;
		for (int i=l+1; i<=h; i++) {
			v2=array[i];
			if (v2<v) {
				for (int j=i; j>p; j--) array[j]=array[j-1];
				array[p]=v2;
				p++;
			}
		}
		if (l<p-1)
			array=quick(array, l, p-1);
		if (p+1<h)
			array=quick(array, p+1, h);
		return array;
		
	}

	public static void main(int[] array) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		String[] in = input.readLine().split(" ");
//		int l = in.length;
////		int[] array = new int[l];
//		for (int i = 0; i < l; i++)
//			array[i] = Integer.parseInt(in[i]);
		array=quick(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

	}

}
