package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Spreadsheet {
	
	static int[][] nsheet=new int[10][9], v=new int[10][9];
	static HashMap<Integer, ArrayList<Integer>> from=new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> xy=new ArrayList<Integer>();
	static ArrayList<String[]> go=new ArrayList<String[]>();
	static HashMap<String, Integer> A=new HashMap<String, Integer>() {{
		put("A", 0);
		put("B", 1);
		put("C", 2);
		put("D", 3);
		put("E", 4);
		put("F", 5);
		put("G", 6);
		put("H", 7);
		put("I", 8);
		put("J", 9);
	}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<10; i++) {
			String[] line=input.readLine().split(" ");
			for (int j=0; j<9; j++) {
				try {
					nsheet[i][j]=Integer.parseInt(line[j]);
					v[i][j]=1;
				}
				catch (NumberFormatException nfe) {
					go.add(line[j].split("[+|]"));
					xy.add(i*10+j);
				}
			}
		}
		for (int t=0; t<91 && !go.isEmpty(); t++) {
			ArrayList<Integer> nxy=new ArrayList<Integer>();
			ArrayList<String[]> ngo=new ArrayList<String[]>();
			for (int i=0; i<go.size(); i++) {
				if (find(i)==0) {
					nxy.add(xy.get(i));
					ngo.add(go.get(i));
				}
			}
			xy=nxy;
			go=ngo;
		}
		for (int i=0; i<10; i++) {
			for (int j=0; j<9; j++) {
				if (v[i][j]==1) System.out.print(nsheet[i][j]+" ");
				else System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static int find(int i) {
		for (int j=0; j<go.get(i).length; j++) {
			if (go.get(i)[j]!=null) {
				int x=A.get(go.get(i)[j].substring(0, 1)), y=Integer.parseInt(go.get(i)[j].substring(1))-1, x1=xy.get(i)/10, y1=xy.get(i)%10;
				if (v[x][y]==1) {
					nsheet[x1][y1]+=nsheet[x][y];
					go.get(i)[j]=null;
					if (Null(i)==1) {
						v[x1][y1]=1;
						return 1;
					}
				}
			}
		}
		return 0;
	}
	public static int Null(int i) {
		for (int j=0; j<go.get(i).length; j++) {
			if (go.get(i)[j]!=null)
				return 0;
		}
		return 1;
	}
}
