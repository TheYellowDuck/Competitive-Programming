package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Wheres_Waldorf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, ArrayList<int[]>> map=new HashMap<Character, ArrayList<int[]>>();
		ArrayList<int[]> list;
		int[] coor=new int[2];
		char[][] grid;
		String[] inp;
		char[] in;
		int r, c, tc;
		char v;
		int tcs=Integer.parseInt(input.readLine());
		for (; tcs>0; tcs--) {
			inp=input.readLine().split(" ");
			r=Integer.parseInt(inp[0]);
			c=Integer.parseInt(inp[1]);
			grid=new char[r][c];
			for (int i=0; i<r; i++) {
				in=input.readLine().toLowerCase().toCharArray();
				for (int j=0; j<c; j++) {
					v=in[j];
					coor[0]=i;
					coor[1]=j;
					list=new ArrayList<int[]>();
					list=map.getOrDefault(v, new ArrayList<int[]>());
					list.add(coor.clone());
					map.put(v, list);
					grid[i][j]=v;
				}
			}
//			System.out.println(Arrays.deepToString(grid));
//			System.out.println("{");
//			for (char i:map.keySet()) {
//				System.out.println("    "+i+" {");
//				for (int j=0; j<map.get(i).size(); j++) {
//					System.out.println("        "+j+" --> "+Arrays.toString(map.get(i).get(j)));
//				}
//				System.out.println("    }");
//			}
//			System.out.println("}");
			for (tc=Integer.parseInt(input.readLine()); tc>0; tc--) {
				in=input.readLine().toLowerCase().toCharArray();
				v=in[0];
				list=map.get(v);
				for (int i=1; i<list.length; i++)
				
			}
		}
		

	}

}
