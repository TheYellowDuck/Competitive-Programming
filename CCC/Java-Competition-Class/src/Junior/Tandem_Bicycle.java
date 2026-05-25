package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tandem_Bicycle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int type=(int) Double.parseDouble(input.readLine());
		int length=(int) Double.parseDouble(input.readLine());
		String[] sarray1=input.readLine().split(" ");
		String[] sarray2=input.readLine().split(" ");
		int[] array1=new int[length];
		int[] array2=new int[length];
		for (int i=0; i<length; i++) {
			array1[i]=(int) Double.parseDouble(sarray1[i]);
			if (type==1)
				array2[i]=(int) Double.parseDouble(sarray2[i]);
			else
				array2[i]=-(int) Double.parseDouble(sarray2[i]);
		}
		int total=0;
		switch (type) {
		case 1:
			Arrays.parallelSort(array1);
			Arrays.parallelSort(array2);
			for (int i=0; i<length; i++) {
				if (array1[i]>array2[i])
					total+=array1[i];
				else
					total+=array2[i];
			}
			System.out.println(total);
			break;
		case 2:
			Arrays.parallelSort(array1);
			Arrays.parallelSort(array2);
			for (int i=0; i<length; i++) {
				array2[i]*=-1;
				if (array1[i]>array2[i])
					total+=array1[i];
				else
					total+=array2[i];
			}
			System.out.println(total);
			break;
		}
	}

}
