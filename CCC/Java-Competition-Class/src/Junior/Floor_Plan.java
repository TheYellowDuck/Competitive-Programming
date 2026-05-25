package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Floor_Plan {
	static int t, r, c;
	static int[][] plan, visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(input.readLine()); r=Integer.parseInt(input.readLine()); c=Integer.parseInt(input.readLine()); int room=0;
		double a=System.currentTimeMillis();long bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		plan=new int[r][c];
		visited=new int[r][c];
		for (int i=0; i<r; i++) {
			char[] line=input.readLine().toCharArray();
			for (int j=0; j<c; j++) if (line[j]=='I') plan[i][j]=-1;
		}
		for (int i=0; i<r; i++) for (int j=0; j<c; j++) if(plan[i][j]==0 && visited[i][j]==0) { room++; find(i, j, room);}
		int[] rooms=new int[room];
		for (int rms=1; rms<=room; rms++) for (int i=0; i<r; i++) for (int j=0; j<c; j++) if(plan[i][j]==rms) rooms[rms-1]++;
		Arrays.parallelSort(rooms);
		room=0;
		for (int i=rooms.length-1; i>=0 && t>=rooms[i]; i--, room++) t-=rooms[i];
		System.out.println(room+(room==1? " room, ":" rooms, ")+t+" square metre(s) left over");
		System.out.println((System.currentTimeMillis()-a)+"\n"+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM));
	}
	public static void find(int rw, int cl, int room) {
		plan[rw][cl]=room; 
    	visited[rw][cl]=1; 
    	if (rw-1>=0 && visited[rw-1][cl]==0 && plan[rw-1][cl]!=-1) find (rw-1, cl, room);
    	if (rw+1<r && visited[rw+1][cl]==0 && plan[rw+1][cl]!=-1) find (rw+1, cl, room);
    	if (cl-1>=0 && visited[rw][cl-1]==0 && plan[rw][cl-1]!=-1) find (rw, cl-1, room);
    	if (cl+1<c && visited[rw][cl+1]==0 && plan[rw][cl+1]!=-1) find (rw, cl+1, room);
    }
}
