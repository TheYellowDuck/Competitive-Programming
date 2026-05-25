package Junior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Strategic_Bombing {
    static Node[] nodes=new Node[26];
    static int numRoads=0;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String line=input.readLine();
        while (!line.contentEquals("**")) {
        	char[] chars=line.toCharArray();
        	Node n=getNode(chars[0]);
        	Node n2=getNode(chars[1]);
        	n.connected.add(n2);
        	n2.connected.add(n);
        	line=input.readLine();
        }
        input.close();
        if (pathFind1()==true) {
	        List<Node> path=new ArrayList<Node>();
	        Node node=nodes[1];
	        while (node!=null) {
	        	path.add(node);
	        	node=node.from;
	        }
	        for (int i=0; i<path.size()-1; i++) {
	        	Node node2=path.get(i+1);
	        	path.get(i).connected.remove(node2);
	        	refreshNodes();
	        	if (pathFind2(path.get(i), node2)==false) {
	        		numRoads++;
	        		System.out.println((char) path.get(i).value+""+(char) node2.value);
	        	}
	        	path.get(i+1).connected.add(node2);
	        }
        }
        System.out.println("There are "+numRoads+" disconnecting roads.");
    }
    
    public static Node getNode(char val) {
    	int index=val-'A';
    	Node n=nodes[index];
    	if (n==null) {
    		n=new Node(val);
    		nodes[index]=n;
    	}
    	return n;
    }
    public static boolean pathFind1() {
    	Node startNode=nodes[0];
    	Node endNode=nodes[1];
        List<Node> frontier=new ArrayList<>();
        frontier.add(startNode);
        startNode.visited=true;
        while(!frontier.isEmpty()){
            List<Node> newFrontier=new ArrayList<Node>();
            for (Node node:frontier) {
            	if (node==endNode)
            		return true;
                List<Node> neighbours=node.getNeighbours();
                for (Node neighbour:neighbours) {
                	if (neighbour.visited==false) {
	                    newFrontier.add(neighbour);
	                    neighbour.visited=true;
	                    neighbour.from=node;
                	}
                }
            }
            frontier=newFrontier;
        }
        return false;
    }
    public static boolean pathFind2(Node startNode, Node endNode) {
        List<Node> frontier=new ArrayList<>();
        frontier.add(startNode);
        startNode.visited=true;
        while(!frontier.isEmpty()){
            List<Node> newFrontier=new ArrayList<Node>();
            for (Node node:frontier) {
            	if (node==endNode)
            		return true;
                List<Node> neighbours=node.getNeighbours();
                for (Node neighbour:neighbours) {
                	if (neighbour.visited==false) {
	                    newFrontier.add(neighbour);
	                    neighbour.visited=true;
                	}
                }
            }
            frontier=newFrontier;
        }
        return frontier.contains(endNode);
    }
    
    public static void refreshNodes() {
    	for (int i=0; i<nodes.length; i++) {
    		if (nodes[i]!=null)
    			nodes[i].visited=false;
    	}
    }

    public static class Node{
    	ArrayList<Node> connected=new ArrayList<Node>();
        int value;
        boolean visited=false;
        Node from;
        public Node(int value){
            this.value=value;
        }
        public List<Node> getNeighbours(){
            List<Node> neighbours=new ArrayList<Node>();
            for(Node node:connected) {
                if(!node.visited)
                    neighbours.add(node);
            }
            return neighbours;
        }
    }
}
