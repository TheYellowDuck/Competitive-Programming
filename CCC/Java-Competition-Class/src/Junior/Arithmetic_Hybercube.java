package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Arithmetic_Hybercube {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(input.readLine());
		String[] in = input.readLine().split(" ", l);
		int[] array = new int[l];
		for (int i = 0; i < l; i++)
			array[i] = Integer.parseInt(in[i]);
		Arrays.parallelSort(array);
		for (int i : array)
			System.out.print(i + " ");
	}

}
