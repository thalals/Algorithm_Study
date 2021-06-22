package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.TreeSet;

public class 여행가자_1976 {
	
	static TreeSet<Integer>[] map;
	static boolean check = false;
	
	static int last_stage = -1;
	static Deque<Integer> dqlist = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine()); //여행갈 도시
		
		map = new TreeSet[n+1];
		
		for(int i=0;i<n+1;i++)
			map[i] = new TreeSet<Integer>();
		
		for(int i=1;i<n+1;i++) {
			String temp[] = br.readLine().split(" ");
			
			for(int j=0;j<temp.length;j++) {
				if(Integer.parseInt(temp[j])==1) {
					map[i].add(j+1);
					map[j+1].add(i);
				}
			}
		}
		
		String temp[] = br.readLine().split(" ");
		
		int travel[] = new int [m];
		for(int i=0;i<m;i++)
			travel[i] = Integer.parseInt(temp[i]);
		
		for(int i=0;i<travel.length-1;i++) {
			int stage = travel[i];	//현재위치
						
			bfs(stage,travel[i+1]);
			if(!check) {
				System.out.println("NO");
				return;
			}
			last_stage = -1;
			check=false;
		}
		
		System.out.println("YES");
	}
	
	static public void bfs(int start, int destination) {
		if(start==destination) {
			check = true;
			while(!dqlist.isEmpty())
				dqlist.poll();
			return;
		}
		
		Iterator<Integer> list = map[start].iterator();
		
		//하나만 연결된 경우
		if(map[start].size()==1) {
			if(list.next() ==last_stage)
				return;
		}
		else if(map[start].size()==0)
			return;
		
		list = map[start].iterator();
		while(list.hasNext()) {
			int next = list.next();
			dqlist.offer(next);
		}
		
		while(!dqlist.isEmpty()) {
			
			
			last_stage = start;
			int next = dqlist.poll();
			
			bfs(next,destination);
			if(check)
				return;
		}
	}
}
