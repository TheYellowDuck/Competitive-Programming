package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorting_Tests {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int l = in.length;
		int[] array = new int[l];
		for (int i = 0; i < l; i++)
			array[i] = Integer.parseInt(in[i]);
		long a=System.nanoTime();
		Quick_Sort.main(array);
		long b=System.nanoTime()-a;
		long c=System.nanoTime();
		Dual_Pivot_Quick_Sort.main(array);
		long d=System.nanoTime()-b;
		long e=System.nanoTime();
		Merge_Sort.main(array);
		long f=System.nanoTime()-e;
		long y=System.nanoTime();
		Arrays.sort(array);
		long z=System.nanoTime()-y;
		System.out.println("My QuickSort: \n"+c+"ns\n"+"My DualPivotQuickSort: \n"+d+"ns\n"+"My MergeSort: \n"+f+"ns\n"+"Java Default DualPivotQuickSort: \n"+z+"ns");
		

	}

}
