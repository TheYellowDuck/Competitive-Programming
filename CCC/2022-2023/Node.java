import java.util.LinkedList;
import java.util.Queue;

public class Node {
	
	int val, depth = 0, height = 0;
	Node root = this, parent = null, left = null, right = null, predecessor = null, successor = null, min = this, max = this;
	
	Node (int val) {   //for root only
		this.val = val;
	}
	Node (Node root, int val) {
		this.root = root;
		this.val = val;
	}
	Node (Node root, Node parent, int val) {
		this.root = root;
		this.parent = parent;
		this.val = val;
	}
	Node (Node root, int val, int depth) {
		this.root = root;
		this.val = val;
		this.depth = depth;
	}
	Node (Node root, Node parent, int val, int depth) {
		this.root = root;
		this.parent = parent;
		this.val = val;
		this.depth = depth;
	}
	
	void reset () {
		depth = 0; height = 0;
		parent = left = right = predecessor = successor = null; min = max = this;
	}
	
	Object[] insert (int val) {
		return insert (new Node (root, val), 0);
	}
	Object[] insert (int val, int depth) {
		return insert (new Node (root, val), depth);
	}
	Object[] insert (Node val, int depth) {
		if (this.val == val.val)
			return new Object[] {depth, min, max};
		depth ++;
		if (this.val > val.val) {
			if (left == null) {
				val.parent = this;
				val.depth = depth;
				left = val;
				predecessor = val;
				return new Object[] {depth, min, max};
			}
			if (min.val > val.val)
				min = val;
			Object[] arr = left.insert(val, depth);
			height = Math.max(height, (int) arr[0]);
			predecessor = (Node) arr[2];
			return new Object[] {height, min, max};
		}
		if (right == null) {
			val.parent = this;
			val.depth = depth;
			right = val;
			successor = val;
			return new Object[] {depth, min, max};
		}
		if (max.val < val.val)
			max = val;
		Object[] arr = right.insert(val, depth);
		height = Math.max(height, (int) arr[0]);
		successor = (Node) arr[1];
		return new Object[] {height, min, max};
	}
	boolean insert (int[] values) {
		return insert (values, 0, values.length - 1);
	}
	boolean insert (int[] values, int b, int e) {
		int m = (b + e) / 2;
		insert (values[m]);
		if (b <= m - 1) insert(values, b, m - 1);
		if (m + 1 <= e) insert(values, m + 1, e);
		return true;
	}
	
	Node search (Node val) {
		return search (val.val);
	}
	Node search (int val) {
		if (this.val == val)
			return this;
		if (this.val > val) {
			if (left == null) return null;
			return left.search(val);
		}
		if (this.val < val) {
			if (right == null) return null;
			return right.search(val);
		}
		return null;
	}
	
	Node floor (Node val) {
		return floor (val.val, root);
	}
	Node floor (int val, Node min) {
		if (this.val == val)
			return this;
		if (this.val > val) {
			if (left == null) return min;
			return left.search(val);
		}
		if (this.val < val) {
			min = this;
			if (right == null) return min;
			return right.search(val);
		}
		return max;
	}
	Node roof (Node val) {
		return roof (val.val, root);
	}
	Node roof (int val, Node max) {
		if (this.val == val)
			return this;
		if (this.val > val) {
			max = this;
			if (left == null) return max;
			return left.search(val);
		}
		if (this.val < val) {
			if (right == null) return max;
			return left.search(val);
		}
		return max;
	}
	
	Node delete () {
        if (this == root) {
            
        }
        else {
            if (left == null && right == null) {
                if (parent.val > val) {
                    parent.predecessor = null;
                    parent.min = parent;
                    parent.left = null;
                }
                else {
                    parent.successor = null;
                    parent.max = parent;
                    parent.right = null;
                }
            }
            else if (left == null || right == null) {
                Node child;
                child = left == null ? right : left;
                if (parent.val > val) {
                    parent.predecessor = child.max;
                    parent.min = child.min;
                    parent.left = child;
                }
                else {
                    parent.successor = child.min;
                    parent.max = child.max;
                    parent.right = child;
                }
                Queue<Node> Q = new LinkedList<>();
                Q.add(child);
                while (!Q.isEmpty()) {
                    Node n = Q.poll();
                    n.depth --;
                    if (n.left != null)
                        Q.add(n.left);
                    if (n.right != null)
                        Q.add(n.right);
                }
            }
            else {
                Node n = null;
                if (parent.val > val) {
                    parent.predecessor = max;
                    parent.min = min;
                    n = max.delete();
                    parent.left = n;
                }
                else {
                    parent.successor = min;
                    parent.max = max;
                    n = min.delete();
                    parent.right = n;
                }
                n.reset();
                n.parent = parent;
                n.left = left;
                n.right = right;
                n.predecessor = n.left.max;
                n.successor = n.right.min;
                n.min = n.left.min;
                n.max = n.right.max;
                n.height = Math.max(n.left == null ? -1 : n.left.height, n.right == null ? -1 : n.right.height) + 1;
            }
            parent.height = Math.max(parent.left == null ? -1 : parent.left.height, parent.right == null ? -1 : parent.right.height) + 1;
            Node back = parent.parent;
            while (back != null) {
                back.predecessor = back.left == null ? null : back.left.max;
                back.successor = back.right == null ? null : back.right.min;
                back.min = back.left == null ? back : back.left.min;
                back.max = back.right == null ? back : back.right.max;
                back.height = Math.max(back.left == null ? -1 : back.left.height, back.right == null ? -1 : back.right.height) + 1;
                back = back.parent;
            }
        }
		return this;
	}
	
	Node getMin () {
		return min;
	}
	Node getMax () {
		return max;
	}
	Node getPredecessor () {
		return predecessor;
	}
	Node getSuccessor () {
		return successor;
	}
	int getHeight () {
		return height;
	}
	int getDepth() {
		return depth;
	}
	int getDepth(Node reference) {
		return depth - reference.depth;
	}
	
	void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print(val + " ");
		if (right != null)
			right.printInOrder();
	}
	
	void printGraph() {
		System.out.print(val + " ");
		if (left != null) 
			left.printGraph();
        else 
            System.out.print("   ");
		if (right != null) 
			right.printGraph();
        else 
            System.out.print("   ");
	}

}
