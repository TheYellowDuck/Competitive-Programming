package Built_in_Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class DMOPC_16_Contest_4_P3_Carnival_Phantasm {
	
	static class SortByDistance implements Comparator<Stall> {

		@Override
		public int compare(Stall a, Stall b) {
			// TODO Auto-generated method stub
			return a.distance - b.distance;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		SortByDistance comparator = new SortByDistance();
		HashMap<Integer, TreeSet<Stall>> candieApples = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int S = Integer.parseInt(in[0]) + 1, T = Integer.parseInt(in[1]);
		Stall[] stalls = new Stall[S];
		in = br.readLine().split(" ");
		
		for (int i = 1; i < S; i++) 
			stalls[i] = new Stall(i, Integer.parseInt(in[i - 1]));
		
		while (T > 0) {
			
			in = br.readLine().split(" ");
			int s = Integer.parseInt(in[0]), c = Integer.parseInt(in[1]);
			
			stalls[s].candieApples[c] = true;
			TreeSet<Stall> set = candieApples.getOrDefault(c, new TreeSet<>(comparator));
			set.add(stalls[s]);
			candieApples.put(c, set);
			
			T--;
		}
		
		T = Integer.parseInt(br.readLine());
		
		while (T > 0) {
			
			in = br.readLine().split(" ");
			int s, c;
			TreeSet<Stall> set;
			
			switch(in[0]) {
			case "A" :
				
				s = Integer.parseInt(in[1]);
				c = Integer.parseInt(in[2]);
				
				stalls[s].candieApples[c] = true;
				set = candieApples.getOrDefault(c, new TreeSet<>(comparator));
				set.add(stalls[s]);
				candieApples.put(c, set);
				
				break;
				
			case "S" :
				
				s = Integer.parseInt(in[1]);
				c = Integer.parseInt(in[2]);
				
				stalls[s].candieApples[c] = false;
				set = candieApples.getOrDefault(c, new TreeSet<>(comparator));
				set.remove(stalls[s]);
				candieApples.put(c, set);
				
				break;
				
			case "E" :
				
				s = Integer.parseInt(in[1]);
				c = Integer.parseInt(in[2]);
				
				for (int i = 1; i < stalls[s].candieApples.length; i++) {
					if (stalls[s].candieApples[i]) {
						
						stalls[s].candieApples[i] = false;
						set = candieApples.getOrDefault(i, new TreeSet<>(comparator));
						set.remove(stalls[s]);
						candieApples.put(i, set);
						
					}
				}
				
				stalls[s].distance = c;
				
				break;
				
			case "Q" :
				
				c = Integer.parseInt(in[1]);
				
				System.out.println(candieApples.get(c) == null ? -1 : candieApples.get(c).size() == 0 ? -1 : candieApples.get(c).first().stallNum);
				
				break;
			}
			
			T--;
		}

	}
	
	static class Stall {
		
		int stallNum, distance;
		
		boolean[] candieApples = new boolean[101];
		
		Stall(int stallNum, int distance) {
			this.stallNum = stallNum;
			this.distance = distance;
		}
		
	}

}
