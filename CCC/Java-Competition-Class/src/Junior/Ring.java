package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ring {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int T, L;
	static long X;
	static HashMap<String, ArrayList<String[]>> FS = new HashMap<String, ArrayList<String[]>>();
	static String k;
	
	public static void FUN(String[] in) throws IOException {
		ArrayList<String[]> F = new ArrayList<String[]>();
		k = in[1];
		in = input.readLine().split(" ");
		L--;
		while (!in[0].contentEquals("END")) {
			F.add(in);
			if (in[0].contentEquals("FUN"))
				FUN(in);
			in = input.readLine().split(" ");
			L--;
		}
		FS.put(k, new ArrayList<String[]>(F));
	}

	public static void Switch(String[] in) throws IOException {
		switch (in[0]) {
		case "ADD":
			X += Integer.parseInt(in[1]);
			break;
		case "SUB":
			X -= Integer.parseInt(in[1]);
			break;
		case "MULT":
			X *= Integer.parseInt(in[1]);
			break;
		case "FUN":
			FUN(in);
			break;
		case "CALL":
			ArrayList<String[]> F = new ArrayList<String[]>(FS.get(in[1]));
			for (String[] c : F)
				Switch(c);
			break;
		}
		X %= 1000000007;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		T = Integer.parseInt(input.readLine());
		String[] in;
		while (T > 0) {
			FS.clear();
			X = 0;
			L = Integer.parseInt(input.readLine());
			while (L > 0) {
				in = input.readLine().split(" ");
				Switch(in);
				L--;
			}
			System.out.println(X);
			T--;
		}

	}

}
