package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class The_Odd_Number {
	static HashMap<Integer, Integer> map=new HashMap<Integer, Integer>(), map2=new HashMap<Integer, Integer>(), map3=new HashMap<Integer, Integer>(), map4=new HashMap<Integer, Integer>();
	public static class ot implements Runnable {
		public void run() {
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.addAll(map2.keySet());
			for (int i=0; i<list.size(); i++) {
				int val=list.get(i);
				if (map.get(val)==null) map.put(val, 1);
				else map.remove(val, 1);
			}
		} 
	}
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine());
		int l2=l/2;
		Thread ot=new Thread(new ot());
		for (int i=0; i<l2; i++) {
			int val=Integer.parseInt(input.readLine());
			if (i%2==0) {
				if (map.get(val)==null) map.put(val, 1);
				else map.remove(val, 1);
			}
			else {
				if (map2.get(val)==null) map2.put(val, 1);
				else map2.remove(val, 1);
			}
		}
		ot.start();
		for (int i=l2; i<l; i++) {
			int val=Integer.parseInt(input.readLine());
			if (i%2==0) {
				if (map3.get(val)==null) map3.put(val, 1);
				else map3.remove(val, 1);
			}
			else {
				if (map4.get(val)==null) map4.put(val, 1);
				else map4.remove(val, 1);
			}
		}
		ot.join();
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.addAll(map4.keySet());
		for (int i=0; i<list.size(); i++) {
			int val=list.get(i);
			if (map3.get(val)==null) map3.put(val, 1);
			else map3.remove(val, 1);
		}
		list=new ArrayList<Integer>();
		list.addAll(map3.keySet());
		for (int i=0; i<list.size(); i++) {
			int val=list.get(i);
			if (map.get(val)==null) map.put(val, 1);
			else map.remove(val, 1);
		}
		System.out.println(map.keySet().toString().replace("[", "").replace("]", ""));
	}

}
