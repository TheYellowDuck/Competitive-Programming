package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Crayola_Lightsaber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(input.readLine());
		int[] colours=new int[5];
		String[] in=input.readLine().split(" ");
		Integer[] array=new Integer[in.length];
		for (String s:in) {
			switch (s) {
			case "red":
				colours[0]++;
				break;
			case "orange":
				colours[1]++;
				break;
			case "yellow":
				colours[2]++;
				break;
			case "green":
				colours[3]++;
				break;
			case "blue":
				colours[4]++;
				break;
			case "black":
				colours[5]++;
				break;
			}
		}
		Arrays.parallelSort(colours);
	}

}
