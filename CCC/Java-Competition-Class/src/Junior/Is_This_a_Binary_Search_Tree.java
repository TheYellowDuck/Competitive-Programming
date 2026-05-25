package Junior;

public class Is_This_a_Binary_Search_Tree {
	public static void main(String[] args) {
		Node n=new Node(18);
		n.left=new Node(8);
		n.right=new Node(20);
		n.right.left=new Node(18);
		n.right.right=new Node(30);
		System.out.println(checkBST(n));
	}
//	static boolean checkBST(Node n) {
//        if (n==null) return true;
//        int v=n.val, l=left(n.left), r=right(n.right);
//        if (l>=v || r<=v) return false;
//        return true;
//    }
//    static int left(Node n) {
//        if (n==null) return Integer.MIN_VALUE;
//        int v=n.val, l=left(n.left), r=right(n.right);
//        if (l>=v || r<=v) return Integer.MAX_VALUE;
//        return Math.max(l==Integer.MAX_VALUE?Integer.MIN_VALUE:l, Math.max(v, r==Integer.MAX_VALUE?v:r));
//    }
//    static int right(Node n) {
//        if (n==null) return Integer.MAX_VALUE;
//        int v=n.val, l=left(n.left), r=right(n.right);
//        if (l>=v || r<=v) return Integer.MIN_VALUE;
//        return Math.min(r==Integer.MIN_VALUE?Integer.MAX_VALUE:r, Math.min(v, l==Integer.MIN_VALUE?v:l));
//    }
	
    
    
	private static boolean checkBST(Node n, int min, int max) {
        if(n == null) return true;
        int v=n.val;
        return (v > min && v < max) && (checkBST(n.left, min, v) && checkBST(n.right, v, max));
    }

    static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
