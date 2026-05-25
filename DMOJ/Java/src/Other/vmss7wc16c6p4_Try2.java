package Other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class vmss7wc16c6p4_Try2 {
 
    static int time, count = 0;
    static ArrayList<ArrayList<Integer> > graph;
 
    static void addEdge(int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
 
    static void APUtil(int u,
                       boolean visited[], int disc[], int low[],
                       int parent, boolean isAP[])
    {
        // Count of children in DFS Tree
        int children = 0;
 
        // Mark the current node as visited
        visited[u] = true;
 
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
 
        // Go through all vertices adjacent to this
        for (Integer v : graph.get(u)) {
            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v]) {
                children++;
                APUtil(v, visited, disc, low, u, isAP);
 
                // Check if the subtree rooted with v has
                // a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);
 
                // If u is not root and low value of one of
                // its child is more than discovery value of u.
                if (parent != -1 && low[v] >= disc[u]) {
                    if (isAP[u] == false) count ++;
                    isAP[u] = true;
                }
            }
 
            // Update low value of u for parent function calls.
            else if (v != parent)
                low[u] = Math.min(low[u], disc[v]);
        }
 
        // If u is root of DFS tree and has two or more children.
        if (parent == -1 && children > 1) {
            if (isAP[u] == false) count ++;
            isAP[u] = true;
        }
    }
 
    static void AP(int V)
    {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        int par = -1;
        time = 0;
        int take = 0;
        for (int u = 0; u < V; u++) {
            if (visited[u] == false) {
            	take ++;
                APUtil(u, visited, disc, low, par, isAP);
            }
            if (take == 2)
            	break;
        }
                
        System.out.println(count);
        for (int u = 0; u < V; u++)
            if (isAP[u] == true)
                System.out.println(u);
    }
 
    public static void main(String[] args) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]) + 1, M = Integer.parseInt(in[1]);
		graph = new ArrayList<ArrayList<Integer> >(N);
        for (int i = 1; i <= N; i++)
            graph.add(new ArrayList<Integer>());
		while (M > 0) {
			in = br.readLine().split(" ");
			int n1 = Integer.parseInt(in[0]), n2 = Integer.parseInt(in[1]);
			addEdge (n1, n2);
			M --;
		}
 
        AP(N);
    }
}