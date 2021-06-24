package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 바이러스_2606 {
	
	static int count=-1;	// 1번 제외
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int vertex = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		visit = new boolean[vertex+1];
		
		for(int i =0;i<vertex+1;i++)
			map.add(new ArrayList<Integer>());
		
		for(int i=0;i<line;i++) {
			String temp[] = br.readLine().split(" ");
			
			map.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
			map.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
		}
		dfs(1,map);
		System.out.println(count);
		
	}
	
	public static void dfs(int start, ArrayList<ArrayList<Integer>> map) {
		if(visit[start])
			return;
		
		visit[start] = true;
		count+=1;
		
		for(int a : map.get(start)) {
			if(!visit[a])
				dfs(a,map);
		}
			
	}

}
