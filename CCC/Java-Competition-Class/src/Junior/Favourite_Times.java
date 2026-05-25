package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Favourite_Times {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] array=new int[] {34, 71, 83, 95, 107, 119, 130, 142, 154, 166, 178, 201, 213, 225, 237, 260, 272, 284, 296, 331, 243, 255, 390, 402, 414, 461, 473, 520, 532, 591, 671};
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int min=Integer.parseInt(input.readLine());
		int b=min/array.length;
		min%=array.length;
		for (int i=0; i<array.length; i++) {
			if (array[i]>min) {
				System.out.println(b+i);
				break;
			}
		}
	}

}
