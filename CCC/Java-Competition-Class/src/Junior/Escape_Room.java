package Junior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Escape_Room {
    public static int M;
    public static int N;
    public static Tile[][] map;
    public static HashMap<Integer, List<Tile>> valMap=new HashMap<Integer, List<Tile>>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        M=Integer.parseInt(reader.readLine());
        N=Integer.parseInt(reader.readLine());
        map=new Tile[M][N];
        for (int i=0; i<M; i++) {
            String rawLine=reader.readLine();
            String[] line=rawLine.split(" ");
            for (int j=0; j<N; j++) {
                int val=Integer.parseInt(line[j]);
                Tile tile=new Tile(i+1, j+1, val);
                map[i][j]=tile;
                List<Tile> list=valMap.get(val);
                if(list==null)
                    list=new ArrayList<Tile>();
                list.add(tile);
                valMap.put(val, list);
            }
        }
        Tile startTile=map[M-1][N-1];
        Tile endTile=map[0][0];
        List<Tile> frontier=new ArrayList<>();
        frontier.add(startTile);
        startTile.visited=true;
        while(!frontier.isEmpty()){
            List<Tile> newFrontier=new ArrayList<Tile>();
            for (Tile tile:frontier){
                List<Tile> neighbours=tile.getNeighbours();
                for (Tile neighbour:neighbours){
                    if(neighbour==endTile){
                        System.out.println("yes");
                        return;
                    }
                    newFrontier.add(neighbour);
                    neighbour.visited = true;
                }
            }
            frontier=newFrontier;
        }
        System.out.println("no");
    }


    public static class Tile{
        int x, y;
        int value;
        boolean visited=false;
        public Tile(int x, int y, int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
        public List<Tile> getNeighbours(){
            List<Tile> neighbours=new ArrayList<Tile>();
            int product=x*y;
            List<Tile> list=valMap.get(product);
            if(list==null)
                return neighbours;
            else{
                for(Tile tile:list){
                    if(!tile.visited)
                        neighbours.add(tile);
                }
            }
            return neighbours;
        }
    }
}
