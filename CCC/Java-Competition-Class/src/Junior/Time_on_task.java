package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Time_on_task {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int min=(int) Double.parseDouble(input.readLine()), num=(int) Double.parseDouble(input.readLine()), sum=0;
		int[] array=new int[num];
		for (int i=0; i<num; i++) {
			int val=(int) Double.parseDouble(input.readLine());
			array[i]=val;
		}
		Arrays.sort(array);
		int i;
		for (i=0; sum<min && i<num; i++) {
			sum+=array[i];
		}
		if (sum>min)
			i--;
		System.out.println(i);
	}

}
