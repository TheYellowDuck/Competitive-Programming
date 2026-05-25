package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cell_Phone_Messaging {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String str=input.readLine();
		while (!str.contentEquals("halt")) {
			int s=0;
			ArrayList<Integer> c=new ArrayList<Integer>();
			c.add(0);
			char[] a=str.toCharArray();
			for (int i=0; i<a.length; i++) {
				switch (a[i]) {
				case 'a':
					s++;
					c.add(1);
					break;
				case 'b':
					s+=2;
					c.add(1);
					break;
				case 'c':
					s+=3;
					c.add(1);
					break;
				case 'd':
					s++;
					c.add(2);
					break;
				case 'e':
					s+=2;
					c.add(2);
					break;
				case 'f':
					s+=3;
					c.add(3);
					break;
				case 'g':
					s++;
					c.add(4);
					break;
				case 'h':
					s+=2;
					c.add(4);
					break;
				case 'i':
					s+=3;
					c.add(4);
					break;
				case 'j':
					s++;
					c.add(5);
					break;
				case 'k':
					s+=2;
					c.add(5);
					break;
				case 'l':
					s+=3;
					c.add(5);
					break;
				case 'm':
					s++;
					c.add(6);
					break;
				case 'n':
					s+=2;
					c.add(6);
					break;
				case 'o':
					s+=3;
					c.add(6);
					break;
				case 'p':
					s++;
					c.add(7);
					break;
				case 'q':
					s+=2;
					c.add(7);
					break;
				case 'r':
					s+=3;
					c.add(7);
					break;
				case 's':
					s+=4;
					c.add(7);
					break;
				case 't':
					s++;
					c.add(8);
					break;
				case 'u':
					s+=2;
					c.add(8);
					break;
				case 'v':
					s+=3;
					c.add(8);
					break;
				case 'w':
					s++;
					c.add(9);
					break;
				case 'x':
					s+=2;
					c.add(9);
					break;
				case 'y':
					s+=3;
					c.add(9);
					break;
				case 'z':
					s+=4;
					c.add(9);
					break;
				}
				if (c.get(i)==c.get(i+1))
					s+=2;
			}
			System.out.println(s);
			str=input.readLine();
		}
	}

}
