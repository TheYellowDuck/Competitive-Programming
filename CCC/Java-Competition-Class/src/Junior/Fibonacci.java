package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci {
	static Integer[] series;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		double a=System.nanoTime();long bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		series=new Integer[n];
		series[0]=1;
		series[1]=1;
		System.out.println(cal(n-1));
		System.out.println((System.nanoTime()-a)+"\n"+(((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM)/1000000));
		a=System.nanoTime(); bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		int[] array=new int[n];
		array[0]=1;
		array[1]=1;
		for (int c=2; c<n; c++) array[c]=array[c-1]+array[c-2];
		System.out.println(array[n-1]);
		System.out.println((System.nanoTime()-a)+"\n"+(((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM)/1000000));
	}
	public static int cal(int n) {
		Integer ans=series[n];
		if (ans==null) ans=cal(n-1)+cal(n-2);
		series[n]=ans;
		return series[n];
	}
}
