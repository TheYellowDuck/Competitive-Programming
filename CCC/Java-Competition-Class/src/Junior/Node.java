package Junior;

//import java.util.ArrayList;

public class Node {
	public int val, nodes=1;
	public Node left, right;
	public Node(Integer val) {
		this.val=val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new Node(4);
		add(n, 2);
		add(n, 8);
		add(n, 3);
		add(n, 6);
//		System.out.println(contains(n, 0));
//		System.out.println(height(n));
//		System.out.println(size(n));
		add(n, 5);
//		print(n);
//		System.out.println();
//		printNodes(n);
//		System.out.println("\n");
		System.out.println(select(n, 5));
//		print(copy(n));
//		System.out.println();
		print(n);
		System.out.println();
		printNodes(n);
		System.out.println();
		n=remove(n, 4);
		print(n);
		System.out.println();
		printNodes(n);
		System.out.println();
//		System.out.println(n.val);
//		print(n);
		System.out.println(floorSearch(n, 9));
	}
	static boolean contains(Node n, int fval) {
		if (n==null) return false;
		if (n.val==fval) return true;
		if (n.val<fval) return contains(n.right, fval);
		return contains(n.left, fval);
	}
	static int height(Node n) {
		if (n==null) return 0;
		int height=1;
		height+=height(n.left);
		height+=height(n.right);
		return height;
	}
	static int size(Node n) {
		if (n==null) return 0;
		return n.nodes+1;
	}
//	static ArrayList<Integer> print(Node n) {
//		ArrayList<Integer> list=new ArrayList<Integer>();
//		if (n.left!=null) list.addAll(print(n.left));
//		list.add(n.val);
//		if (n.right!=null) list.addAll(print(n.right));
//		return list;
//	}
	static void print(Node n) {
		if (n!=null) {
			print(n.left);
			System.out.print(n.val+" ");
			print(n.right);
		}
	}
	static void printNodes(Node n) {
		if (n!=null) {
			printNodes(n.left);
			System.out.print(n.nodes+" ");
			printNodes(n.right);
		}
	}
//	static void printNodes(Node n) {
//		if (n.left!=null)
//			System.out.print(n.left.nodes+" ");
//		if(n.right!=null)
//			System.out.println(n.right.nodes);
//		else System.out.println();
//		if (n.left!=null) printNodes(n.left);
//		if (n.right!=null) printNodes(n.right);
//	}
	static Node add(Node n, int aval) {
		if (n==null) return null;
		if (n.val==aval) return n;
		if (n.val<aval) {
			if (n.right==null) {
				n.right=new Node(aval);
				n.nodes++;
				return n;
			}
			add(n.right, aval);
			n.nodes=(n.left==null?0:n.left.nodes+1)+(n.right==null?0:n.right.nodes+1);
			return n;
		}
		if (n.left==null) {
			n.left=new Node(aval);
			n.nodes++; 
			return n;
		}
		add(n.left, aval);
		n.nodes=(n.left==null?0:n.left.nodes+1)+(n.right==null?0:n.right.nodes+1);
		return n;
	}
//	static int select(Node n, int e) {
//		return print(n).get(e);
//	}
//	static Integer select(Node n, int e) {
//		if (n==null) return null;
//		int size=n.left==null?0:n.left.nodes;
//		if (size==e) return n.val;
//		if (size<e) return select(n.right, e-size-1);
//		return select(n.left, e);
//	}
	static Integer select(Node n, int e) {
		if (n==null) return null;
		return select(n, e, new Integer[] {null, 0})[0];
	}
	private static Integer[] select(Node n, int e, Integer[] r) {
		if (n.left!=null) {
			r=select(n.left, e, r);
			r[1]++;
		}
		if (r[1]==e) {
			r[0] = n.val;
			return r;
		}
		else if (n.right!=null) {
			r[1]++;
			r=select(n.right, e, r);
		}
		return r;
	}
	static Node toArray(int[] array, int b, int e) {
		int m=(b+e)/2;
		Node n=new Node(array[m]);
		if (b<=m-1) n.left=toArray(array, b, m-1);
		if (m+1<=e) n.right=toArray(array, m+1, e);
		return n;
	}
	static Node copy(Node n) {
		if (n==null) return null;
		Node newn=new Node(n.val);
		newn.left=copy(n.left);
		newn.right=copy(n.right);
		return newn;
	}
	static Node remove(Node n, int v) {
		if (n==null) return null;
		int nv=n.val;
		if (v<nv) {
			n.left=remove(n.left, v);
			n.nodes--;
		}
		else if (v>nv) {
			n.right=remove(n.right, v);
			n.nodes--;
		}
		else {
			if (n.left==null) return n.right;
			else if (n.right==null) return n.left;
			else {
				n.val=n.right.val;
				Node node=n.right;
				while (node.left != null) { 
		            n.val = node.left.val; 
		            node = node.left; 
		        }
				n.right=remove(n.right, n.val);
				n.nodes--;
			}
		}
		return n;
	}
	static int floorSearch(Node n, int e) {
		return floorSearch(n, e, 0);
	}
	private static int floorSearch(Node n, int val, int i) {
		if (n.left!=null) {
			i=floorSearch(n.left, val, i);
			i++;
		}
		if (n.val>val) return i-1;
		else if (n.right!=null) i=floorSearch(n.right, val, i+1);
		return i;
	}

}
