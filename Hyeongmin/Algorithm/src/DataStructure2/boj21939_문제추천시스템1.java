package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class Problem implements Comparable<Problem>{
	int number, level,index;

	Problem(int n, int l, int idx) {
		this.number = n;
		level = l;
		index = idx;
	}
	
	@Override
	public int compareTo(Problem o) {
		if(this.level == o.level) {
			return this.number > o.number ? 1 : -1;	//음수면 유지
		}
		else 
			return this.level > o.level ? 1:-1;
			
	}
}

public class boj21939_문제추천시스템1 {

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Problem> max_heap = new PriorityQueue<Problem>(Collections.reverseOrder());	//내림차순
		PriorityQueue<Problem> min_heap = new PriorityQueue<Problem>();	//오름차순
		
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		String temp[];
		int index =0;
		
		ArrayList<Boolean> visit = new ArrayList<Boolean>();
		
		while(n-->0) {
			temp = br.readLine().split(" ");
			Problem a = new Problem(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),index++);
			max_heap.add(a);
			min_heap.add(a);
			
			list.put(temp[0], index);
			
			visit.add(false);
		}
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			temp = br.readLine().split(" ");
			if(temp[0].equals("add")) {
				Problem a = new Problem(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),index++);
				max_heap.add(a);
				min_heap.add(a);
				visit.add(false);
			}
			
			else if(temp[0].equals("recommend")) {
				if(temp[1].equals("1")) {
					while(!max_heap.isEmpty()) {
						Problem p = max_heap.poll();
						if(!visit.get(p.index)) {
							sb.append(p.number+"\n");
							visit.set(p.index, true);
							break;
						}
					}
				}
				else {
					while(!min_heap.isEmpty()) {
						Problem p = min_heap.poll();
						if(!visit.get(p.index)) {
							sb.append(p.number+"\n");
							visit.set(p.index, true);
							break;
						}
					}
				}
			}
			
			else if(temp[0].equals("solved")) {
				int get_idx = list.get(temp[1]);
				visit.set(get_idx, true);
			}
		}
		
		System.out.println(sb.toString());
	}

}
