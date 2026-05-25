package Junior;

import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=Integer.parseInt(input.nextLine());
		int[] array=new int[n*2];
		String[] strarray;
		int maxx=0;
		int minx=Integer.MAX_VALUE;
		int maxy=0;
		int miny=Integer.MAX_VALUE;
		for (int i=0; i<n*2; i=i+2) {
			strarray=input.nextLine().replace(" ", "").split(",");
			array[i]=Integer.parseInt(strarray[0]);
			array[i+1]=Integer.parseInt(strarray[1]);
		}
		for (int i=0; i<n*2; i=i+2) {
			maxx=Math.max(maxx, array[i]);
			maxy=Math.max(maxy, array[i+1]);
			minx=Math.min(minx, array[i]);
			miny=Math.min(miny, array[i+1]);
		}
		System.out.println((minx-1)+", "+(miny-1));
		System.out.println((maxx+1)+", "+(maxy+1));
	}

}
