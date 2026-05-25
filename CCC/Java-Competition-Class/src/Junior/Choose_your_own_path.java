package Junior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Choose_your_own_path {
    static Node[] nodes=new Node[10000];
    static List<Node> endNodes=new ArrayList<Node>(), Nodes=new ArrayList<Node>();
    static int min=0;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int pgs=Integer.parseInt(input.readLine());
        for (int i=1; i<=pgs; i++) {
        	String[] str=input.readLine().split(" ");
        	Node n=getNode(i);
        	int go=Integer.parseInt(str[0]);
        	if (go==0)
        		endNodes.add(n);
        	for (int j=1; j<=go; j++) {
	        	Node n2=getNode(Integer.parseInt(str[j]));
	        	n.connected.add(n2);
        	}
        }
        input.close();
        pathFind();
        System.out.println((visited()?"Y":"N")+"\n"+min);
    }
    
    public static Node getNode(int val) {
    	int index=val-1;
    	Node n=nodes[index];
    	if (n==null) {
    		n=new Node(val);
    		nodes[index]=n;
    		Nodes.add(n);
    	}
    	return n;
    }
    public static void pathFind() {
    	Node startNode=nodes[0];
        List<Node> frontier=new ArrayList<>();
        frontier.add(startNode);
        startNode.visited=1;
        int steps=1;
        while(!frontier.isEmpty()){
        	steps++;
            List<Node> newFrontier=new ArrayList<Node>();
            for (Node node:frontier) {
                List<Node> neighbours=node.getNeighbours();
                for (Node neighbour:neighbours) {
                	if (neighbour.visited==0) {
                		if (min==0)
                			for (Node i:endNodes)
                				min=i==neighbour?steps:min;
	                    newFrontier.add(neighbour);
	                    neighbour.visited=1;
                	}
                }
            }
            frontier=newFrontier;
        }
    }
    
    public static boolean visited() {
    	for (Node i:Nodes)
    		if (i.visited==0)
    			return false;
    	return true;
    }

    public static class Node{
    	ArrayList<Node> connected=new ArrayList<Node>();
        int value;
        int visited=0;
        public Node(int value){
            this.value=value;
        }
        public List<Node> getNeighbours(){
            List<Node> neighbours=new ArrayList<Node>();
            for(Node node:connected) {
                if(node.visited==0)
                    neighbours.add(node);
            }
            return neighbours;
        }
    }
}
