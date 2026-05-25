package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class dmpg15s4 {
	
	static Beacon[] beacons;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int B = Integer.parseInt(in[0]), Q = Integer.parseInt(in[1]);
		beacons = new Beacon[B + 1];
		beacons[0] = new Beacon(0, 0, 0, 0);
		for (int i = 1; i <= B; i ++) {
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]), r = Integer.parseInt(in[2]);
			beacons[i] = new Beacon(x, y, r, i);
			for (int j = i - 1; j >= 1; j --) {
				beacons[i].inRange(beacons[j]);
				beacons[j].inRange(beacons[i]);
			}
		}
		
		for (int i = 0; i < Q; i ++) {
			in = br.readLine().split(" ");
			int b1 = Integer.parseInt(in[0]), b2 = Integer.parseInt(in[1]);
			System.out.println(/*isLit(b1, b2)*/ beacons[b1].inRange.contains(beacons[b2]) ? "YES" : "NO");
		}

	}
	
	static boolean isLit(int b1, int b2) {
		Queue<Beacon> search = new LinkedList<>();
		search.add(beacons[b1]);
		beacons[b1].visited = true;
		while (!search.isEmpty()) {
			for (Beacon j : search.poll().inRange) {
				j.visited = true;
				if (j.i == b2)
					return true;
				search.add(j);
			}
		}
		return false;
	}
	
	static void reset() {
		for (Beacon i : beacons) {
			i.visited = false;
		}
	}
	
	static class Beacon {
		HashSet<Beacon> inRange = new HashSet<>();
		int x, y, r, i;
		boolean visited = false;
		Beacon(int x, int y, int r, int i) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.i = i;
		}
		void inRange(Beacon beacon) {
			double d = Math.sqrt((x - beacon.x ) * (x - beacon.x) + (y - beacon.y ) * (y - beacon.y));
			if (r >= d)
				add(beacon);
		}
		void add(Beacon b) {
			inRange.add(b);
			inRange.addAll(b.inRange);
		}
	}

}
