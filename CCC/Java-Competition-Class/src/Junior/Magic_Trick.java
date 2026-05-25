package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Magic_Trick {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main (String[] args) throws IOException{
        for (int t = 0; t < 5; t++) {
            int N = readInt();
            List<Integer> cards = new ArrayList<>();
            for (int i = 1; i <= N; i++) cards.add(i);
            Collections.reverse(cards);
            List<Integer> ans = new ArrayList<>();
            int impossible = 0;
            for (int i = 0; i < N; i++) {
                int x = readInt();
                if (x >= cards.size()) {
                    impossible = 1;
                    break;
                }
                ans.add(cards.get(x));
                cards.remove(x);
            }
            if (impossible==1) System.out.println("IMPOSSIBLE");
            else {
                for (int x : ans) System.out.print(x + " ");
                System.out.println();
            }
        }
    }

    static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
    }
    
	static int readInt () throws IOException {
		return Integer.parseInt(next());
    }
    
    static String readLine () throws IOException {
		return br.readLine().trim();
	}

}
