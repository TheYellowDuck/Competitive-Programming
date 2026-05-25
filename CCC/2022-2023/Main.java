import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		BST bst = new BST (array);
		bst.root.printInOrder();
		System.out.println();
		bst.root.printGraph();
		System.out.println();
        int a = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < a; i ++) {
            int val = Integer.parseInt(br.readLine()); 
            bst.insert(val);
        }
		bst.root.printInOrder();
		System.out.println();
		bst.root.printGraph();
		System.out.println();
        int b = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < b; i ++) {
            int val = Integer.parseInt(br.readLine()); 
            bst.delete(val);
        }
		bst.root.printInOrder();
		System.out.println();
		bst.root.printGraph();
		System.out.println();

	}

}
