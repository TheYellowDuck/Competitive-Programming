package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class High_Tide_Low_Tide {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int ts=Integer.parseInt(input.readLine());
		String[] in=input.readLine().split(" ");
		int[] array=Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(array);
		for (double i=0, s=(ts+1)/2-1; ts%2!=0 && i<ts; i++, s-=0.5)
			System.out.print(((i+1)%2!=0?array[(int) Math.ceil(ts-s-1)]:array[(int) Math.ceil(s)])+" ");
		for (int i=(ts+1)/2-1; ts%2==0 && i>=0; i--)
			System.out.print(array[i]+" "+array[ts-i-1]+" ");
	}

}
