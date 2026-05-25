package Sorting_Stacks_and_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DWITE_07_R2_4_All_Is_Balanced {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] in, order;
		int index, bool;
		for (int i=0; i<5; i++) {
			bool=0;
			index=0;
			in=input.readLine().toCharArray();
			order=new char[128];
			for (char ch:in) {
				if (ch==40 || ch==91 || ch==123) order[index++]=ch;
				else if (ch==41 || ch==93 || ch==125) {
					index--;
					if (index<0) {
						System.out.println("not balanced");
						bool=1;
					}
					else if (ch==41 && order[index]!=40) {
						System.out.println("not balanced");
						bool=1;
					}
					else if (ch==93 && order[index]!=91) {
						System.out.println("not balanced");
						bool=1;
					}
					else if (ch==125 && order[index]!=123) {
						System.out.println("not balanced");
						bool=1;
					}
				}
				if (bool==1) break;
			}
			if (bool==0) System.out.println("balanced");
		}

	}

}
