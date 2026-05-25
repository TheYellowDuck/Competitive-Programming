package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sawmill {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(input.readLine());
		String[] in = input.readLine().split(" "), in2 = input.readLine().split(" ");
		int[] saws = new int[l], logs = new int[l];
		for (int i = 0; i < l; i++) {
			saws[i] = Integer.parseInt(in[i]);
			logs[i] = Integer.parseInt(in2[i]);
		}
		Arrays.sort(saws);
		Arrays.sort(logs);
		l--;
		long v = 0;
		for (int i = 0; l >= 0; i++, l--)
			v += saws[i] * logs[l];
		System.out.println(v);

	}

}
