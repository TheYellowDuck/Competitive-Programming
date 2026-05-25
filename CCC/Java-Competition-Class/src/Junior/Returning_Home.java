package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Returning_Home {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String direct=input.readLine();
		String road=input.readLine();
		ArrayList<String> instruct=new ArrayList<String>();
		ArrayList<String> roads=new ArrayList<String>();
		while (!road.contentEquals("SCHOOL")) {
			instruct.add(direct);
			roads.add(road);
			direct=input.readLine();
			road=input.readLine();
		}
		instruct.add(direct);
		Collections.reverse(instruct);
		Collections.reverse(roads);
		for (int i=0; i<instruct.size()-1; i++) {
			switch (instruct.get(i)) {
			case "L":
				instruct.set(i, "RIGHT");
				break;
			case "R":
				instruct.set(i, "LEFT");
				break;
			}
			System.out.println("Turn "+instruct.get(i)+" onto "+roads.get(i)+" street.");
		}
		switch (instruct.get(instruct.size()-1)) {
		case "L":
			instruct.set(instruct.size()-1, "RIGHT");
			break;
		case "R":
			instruct.set(instruct.size()-1, "LEFT");
			break;
		}
		System.out.println("Turn "+instruct.get(instruct.size()-1)+" into your HOME.");
	}

}
