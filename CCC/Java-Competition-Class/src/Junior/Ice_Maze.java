package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ice_Maze {
	static Tile[][] map;
	static Tile end=null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		Tile start=null;
		Tile[] P=new Tile[6];
		map=new Tile[10][10];
		int steps, bool;
		char[] in;
		for (int i=0; i<10; i++) {
			in=input.readLine().toCharArray();
			for (int j=0; j<10; j++) {
				Tile tile=new Tile(i, j, in[j]);
				map[i][j]=tile;
				if (in[j]=='A')
					P[0]=tile;
				else if (in[j]=='B')
					P[1]=tile;
				else if (in[j]=='C')
					P[2]=tile;
				else if (in[j]=='D')
					P[3]=tile;
				else if (in[j]=='E')
					P[4]=tile;
				else if (in[j]=='F')
					P[5]=tile;
			}
		}
		ArrayList<Tile> f;
		ArrayList<Tile> nf;
		ArrayList<Tile> n;
		for (int i=0; i<5; i++) {
			start=P[i];
			end=P[i+1];
			f=new ArrayList<Tile>();
			f.add(start);
			start.direction=4;
			steps=0;
			bool=0;
			while (!f.isEmpty() && bool==0) {
				nf=new ArrayList<Tile>();
				steps++;
				for (Tile t:f) {
					n=t.getNeighbours();
					for (Tile nb:n) {
						if (nb==end && nb.direction==4) {
							System.out.println(steps-1);
							bool=1;
							reset();
							break;
						}
						nf.add(nb);
					}
					if (bool==1) break;
				}
				f=nf;
			}
		}
	}
	public static void reset() {
		for (int i=0; i<10; i++)
			for (int j=0; j<10; j++)
				map[i][j].direction=-1;
	}
	public static class Tile{
        int x, y, direction=-1;
        char value;
        public Tile(int x, int y, char value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
        public ArrayList<Tile> getNeighbours(){
            ArrayList<Tile> neighbours=new ArrayList<Tile>();
            int bool=0;
            switch (direction) {
            case 0:
            	if (x-1>=0 && map[x-1][y].value!='#') {
            		neighbours.add(map[x-1][y]);
            		map[x-1][y].direction=0;
            		bool=1;
            	}
            	break;
            case 1:
            	if (y+1<10 && map[x][y+1].value!='#') {
            		neighbours.add(map[x][y+1]);
            		map[x][y+1].direction=1;
            		bool=1;
            	}
            	break;
            case 2:
            	if (x+1<10 && map[x+1][y].value!='#') {
            		neighbours.add(map[x+1][y]);
            		map[x+1][y].direction=2;
            		bool=1;
            	}
            	break;
            case 3:
            	if (y-1>=0 && map[x][y-1].value!='#') {
            		neighbours.add(map[x][y-1]);
            		map[x][y-1].direction=3;
            		bool=1;
            	}
            	break;
            }
            if (bool==0) {
            	bool=direction;
            	direction=4;
            }
            if (direction==4) {
            	if (value==end.value) neighbours.add(map[x][y]);
            	else {
	            	if (bool!=2 && x-1>=0 && map[x-1][y].value!='#') {
	            		neighbours.add(map[x-1][y]);
	            		map[x-1][y].direction=0;
	            		direction=0;
	            	}
	            	if (bool!=3 && y+1<10 && map[x][y+1].value!='#') {
	            		neighbours.add(map[x][y+1]);
	            		map[x][y+1].direction=1;
	            		direction=1;
	            	}
	            	if (bool!=0 && x+1<10 && map[x+1][y].value!='#') {
	            		neighbours.add(map[x+1][y]);
	            		map[x+1][y].direction=2;
	            		direction=2;
	            	}
	            	if (bool!=1 && y-1>=0 && map[x][y-1].value!='#') {
	            		neighbours.add(map[x][y-1]);
	            		map[x][y-1].direction=3;
	            		direction=3;
	            	}
            	}
            }
            return neighbours;
        }
    }
}
