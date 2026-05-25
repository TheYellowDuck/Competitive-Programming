package Junior;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Pinball_Ranking {

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		long a=System.nanoTime();
		System.out.println(Pinball_Ranking_BST.main());
		System.out.println(System.nanoTime()-a);
		long b=System.nanoTime();
		System.out.println(Pinball_Ranking_MergeSort.main());
		System.out.println(System.nanoTime()-b);

	}

}
