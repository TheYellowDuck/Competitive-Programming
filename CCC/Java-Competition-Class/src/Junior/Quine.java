package Junior;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Quine {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(new File("Quine.java")));
		String in;
		while ((in = input.readLine()) != null)
			System.out.println(in);
	}
}