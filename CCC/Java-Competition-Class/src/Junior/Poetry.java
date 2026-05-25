package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poetry {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int poems=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<poems; i++) {
			String[] lines=new String[4];
			for (int j=0; j<4; j++) {
				String line=input.readLine();
				line=line.substring(line.lastIndexOf(" ")+1).toLowerCase();
				Pattern pattern=Pattern.compile("a|e|i|o|u");
				Matcher matcher=pattern.matcher(line);
				int index=-1;
				while (matcher.find()) {
				    index=matcher.end()-1;
				}
				if (index!=-1)
					lines[j]=line.substring(index);
				else
					lines[j]=line;
			}
			if (lines[0].contentEquals(lines[1]) && lines[1].contentEquals(lines[2]) && lines[2].contentEquals(lines[3]))
				System.out.println("perfect");
			else if (lines[0].contentEquals(lines[1]) && lines[2].contentEquals(lines[3]))
				System.out.println("even");
			else if (lines[0].contentEquals(lines[2]) && lines[1].contentEquals(lines[3]))
				System.out.println("cross");
			else if (lines[0].contentEquals(lines[3]) && lines[1].contentEquals(lines[2]))
				System.out.println("shell");
			else
				System.out.println("free");
		}
	}

}
