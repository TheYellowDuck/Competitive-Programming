package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class I_Speak_TXTMSG {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> txt=new HashMap<String,String>() {{
			put("CU", "see you");
			put(":-)", "I'm happy");
			put(":-(", "I'm unhappy");
			put(";-)", "wink");
			put(":-P", "stick out my tongue");
			put("(~.~)", "sleepy");
			put("TA", "totally awesome");
			put("CCC", "Canadian Computing Competition");
			put("CUZ", "because");
			put("TY", "	thank-you");
			put("YW", "you're welcome");
		}};
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String str=input.readLine();
		while (!str.contentEquals("TTYL")) {
			String translation=txt.get(str);
			if (translation==null)
				System.out.println(str);
			else 
				System.out.println(txt.get(str));
			str=input.readLine();
		}
		System.out.println("talk to you later");
	}

}
