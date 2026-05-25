package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Voronoi_Villages {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		double s=Double.MAX_VALUE;
		double[] array=new double[n];
		for (int i=0; i<n; i++)
			array[i]=Integer.parseInt(input.readLine());
		Arrays.parallelSort(array);
		for (int i=1; i<n-1; i++) {
			double r=(array[i+1]-array[i-1])/2;
			if (r<s)
				s=r;
		}
		System.out.println(String.format("%.1f", s));
	}

}
