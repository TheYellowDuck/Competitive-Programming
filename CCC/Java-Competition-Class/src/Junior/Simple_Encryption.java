package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Simple_Encryption {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		char[] key=input.readLine().toCharArray();
		String str=input.readLine().replaceAll("[^A-Z]", "").replace(" ", "");
		ArrayList<char[]> split=new ArrayList<char[]>();
		for (int i=key.length; str.length()>key.length;) {
			split.add(str.substring(0, i).toCharArray());
			if (i<str.length())
				str=str.substring(i);
		}
		split.add(str.toCharArray());
		str="";
		for (int i=0; i<split.size(); i++) {
			for (int j=0; j<split.get(i).length; j++) {
				char encode=(char) (split.get(i)[j]+(key[j]-'A'));
				if (encode>90) {
					encode-=91;
					encode+='A';
				}
				str=str.concat(String.valueOf(encode));
			}
		}
		System.out.println(str);
	}

}
