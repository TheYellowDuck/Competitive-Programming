public class BST {
	
	Node root;
	
	BST (int val) {
		root = new Node(val);
	}
	BST (int[] values) {
		int b = 0, e = values.length - 1;
		int m = (b + e) / 2;
		root = new Node (values[m]);
		if (b <= m - 1) insert(values, b, m - 1);
		if (m + 1 <= e) insert(values, m + 1, e);
	}
	boolean insert (int[] values, int b, int e) {
		int m = (b + e) / 2;
		root.insert (values[m]);
		if (b <= m - 1) insert(values, b, m - 1);
		if (m + 1 <= e) insert(values, m + 1, e);
		return true;
	}
	
	Object[] insert (int val) {
		return root.insert(val);
	}
	boolean insert (int[] values) {
		return root.insert(values);
	}
	
	Node search (int val) {
		return root.search(val);
	}
	Node search (Node n, int val) {
		return n.search(val);
	}
	Node search (Node val) {
		return root.search(val);
	}
	Node search (Node n, Node val) {
		return n.search(val);
	}
	
	Node delete (Node val) {
		return val.delete();
	}
	Node delete (int val) {
		return search(val).delete();
	}
	
	Node getMin (Node val) {
		return val.min;
	}
	Node getMax (Node val) {
		return val.max;
	}
	Node getPredecessor (Node val) {
		return val.predecessor;
	}
	Node getSuccessor (Node val) {
		return val.successor;
	}
	int getHeight (Node val) {
		return val.height;
	}
	int getDepth(Node val) {
		return val.depth;
	}
	int getDepth(Node val, Node reference) {
		return val.depth - reference.depth;
	}
	
	void printInOrder() {
		root.printInOrder();
	}
	
	void printGraph() {
		root.printGraph();
	}

}
