package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Robo_Thieves {
	static int m;
    static int n;
    static Tile[][] map;
    static boolean s=false;
    public static void c(int j, int i, int m, int n, int l, int o) {
    	switch (map[j][i].value) {
		case '.':
			map[j][i].value='W';
			break;
		case 'C':
		case 'W':
			break;
		case 'S':
			s=true;
			break;
		default:
			if (l+o>=0 && map[j+m][i+n].value=='.') 
				map[j+m][i+n].value='W';
			break;
		}
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String str[]=input.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		List<Tile> empty=new ArrayList<Tile>();
		List<Tile> cams=new ArrayList<Tile>();
		Tile startTile=null;
		int step=0;
		map=new Tile[n][m];
		for (int i=0; i<n; i++) {
            String rawline=input.readLine();
            char[] line=rawline.toCharArray();
            for (int j=0; j<m; j++) {
            	Tile tile=new Tile(j, i, line[j]);
                map[i][j]=tile;
                switch (line[j]) {
                case 'S':
                	startTile=map[i][j];
                	break;
                case '.':
                	empty.add(tile);
                	break;
                case 'C':
                	cams.add(tile);
                }
            }
        }
		for (Tile t:cams) {
			int i=t.x;
			int j=t.y;
			c(j-1, i, -1, 0, j, -1);
			c(j+1, i, 1, 0, j, 1);
			c(j, i-1, 0, -1, i, -1);
			c(j, i+1, 0, 1, i, 1);
			map[j][i].value='W';
		}
		if (s==false) {
	        List<Tile> frontier=new ArrayList<>();
	        frontier.add(startTile);
	        startTile.steps=0;
	        while(!frontier.isEmpty()){
	        	step++;
	            List<Tile> newFrontier=new ArrayList<Tile>();
	            for (Tile tile:frontier){
	                List<Tile> neighbours=tile.getNeighbours();
	                for (Tile neighbour:neighbours){
	                    newFrontier.add(neighbour);
	                    neighbour.steps=step;
	                }
	            }
	            frontier=newFrontier;
	        }
        }
        for (Tile t:empty) {
        	System.out.println(t.steps);
        }
    }

    public static class Tile{
        int x,y;
        char value;
        int steps=-1;
        public Tile(int x, int y, char value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
        public List<Tile> getNeighbours(){
        	List<Tile> neighbours = new ArrayList<Tile>();
        	neighbours.add(map[y][x-1]);
        	neighbours.add(map[y][x+1]);
        	neighbours.add(map[y-1][x]);
        	neighbours.add(map[y+1][x]);
        	List<Tile> result = new ArrayList<Tile>();
        	for (int t=0; t<neighbours.size(); t++) {
        		while (neighbours.get(t).value=='U' || neighbours.get(t).value=='D' || neighbours.get(t).value=='L' || neighbours.get(t).value=='R') {
        			switch (neighbours.get(t).value) {
        			case 'U':
        				if (map[neighbours.get(t).y-1][neighbours.get(t).x].value!='W' && map[y-1][x].steps==-1)
        					neighbours.set(t, map[neighbours.get(t).y-1][neighbours.get(t).x]);
        				else 
        					neighbours.get(t).value='W';
        				break;
        			case 'D':
        				if (map[neighbours.get(t).y+1][neighbours.get(t).x].value!='W' && map[y+1][x].steps==-1)
        					neighbours.set(t, map[neighbours.get(t).y+1][neighbours.get(t).x]);
        				else 
        					neighbours.get(t).value='W';
        				break;
        			case 'L':
        				if (map[neighbours.get(t).y][neighbours.get(t).x-1].value!='W' && map[y][x-1].steps==-1)
        					neighbours.set(t, map[neighbours.get(t).y][neighbours.get(t).x-1]);
        				else 
        					neighbours.get(t).value='W';
        				break;
        			case 'R':
        				if (map[neighbours.get(t).y][neighbours.get(t).x+1].value!='W' && map[y][x+1].steps==-1)
        					neighbours.set(t, map[neighbours.get(t).y][neighbours.get(t).x+1]);
        				else 
        					neighbours.get(t).value='W';
        				break;
        			}
        		}
        		if (neighbours.get(t).steps==-1 && neighbours.get(t).value=='.') {
        			result.add(neighbours.get(t));
        		}
        	}
            return result;
        }
    }
}
