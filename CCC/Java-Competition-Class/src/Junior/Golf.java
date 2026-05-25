package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

public class Golf {
	static int[] array;
	static Integer[] ans;
	static int length/* , step=1 */;

//	public static void strokes(int d) {
//		step=ans[d]+1;
//		for (int i:array) {
//			if (d+i<=length && (ans[d+i]==null || step<ans[d+i])) {
//				ans[d+i]=step;step=ans[d]+1;
//				strokes(d+i);
//				step=ans[d]+1;
//			}
//		}
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		length = (int) Double.parseDouble(input.readLine());
		int clubs = (int) Double.parseDouble(input.readLine());
		array = new int[clubs];
		ans = new Integer[length + 1];
		ans[0] = 0;
		for (int i = 0; i < clubs; i++)
			array[i] = (int) Double.parseDouble(input.readLine());
//		for (int d=0, i=0; d<=length; i++) {
//			if (d==100) {
//				System.out.println("Roberta wins in "+i+" strokes.");
//				return;
//			}
//		}
		int s = strokes(length);
		System.out.println(s == -1 ? "Roberta acknowledges defeat." : "Roberta wins in " + s + " strokes.");
//		int step=1;
//		for (int i=0; i<clubs; i++)
//			array[i]=(int) Double.parseDouble(input.readLine());
//		List<Integer> f=new ArrayList<Integer>();
//		Map<Integer, Integer> visited=new HashMap<Integer, Integer>();
//		for (int i:array) {
//			f.add(i);
//			visited.put(i, 1);
//		}
//		while (!f.isEmpty()) {
//			step++;
//			List<Integer> nf=new ArrayList<Integer>();
//			for (int i:f) {
//				for (int j:array) {
//					int a=i+j;
//					if (visited.get(a)==null && a<=length) {
//						if (a==length) {
//							System.out.println("Roberta wins in "+step+" strokes.");
//							return;
//						}
//						nf.add(a);
//						visited.put(a, 1);
//					}
//				}
//			}
//			f=nf;
//		}
//		System.out.println("Roberta acknowledges defeat.");
	}

	public static int strokes(int d) {
		if (d < 0)
			return -1;
		Integer a = ans[d];
		if (a != null)
			return a;
		int min = Integer.MAX_VALUE;
		for (int c : array) {
			int stroke = strokes(d - c);
			if (stroke != -1) {
				min = Math.min(min, 1 + stroke);
			}
		}
		min = min == Integer.MAX_VALUE ? -1 : min;
		ans[d] = min;
		return min;
	}
}
