package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_to_IBST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		int l = in.length;
		int[] array = new int[l];
		for (int i = 0; i < l; i++)
			array[i] = Integer.parseInt(in[i]);
		Node n=convert(array, 0, l-1);
		Node.print(n);
	}
	static Node convert(int[] array, int b, int e) {
		int m=(b+e)/2;
		Node n=new Node(array[m]);
		if (b<=m-1) n.left=convert(array, b, m-1);
		if (m+1<=e) n.right=convert(array, m+1, e);
		return n;
	}
}
