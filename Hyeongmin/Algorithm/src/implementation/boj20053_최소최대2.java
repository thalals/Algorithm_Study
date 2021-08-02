package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class boj20053_최소최대2 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			int t = Integer.parseInt(br.readLine());
			String temp[] = br.readLine().split(" ");
			
			ArrayList<Integer> s = new ArrayList<Integer>();
			for(String q : temp)
				s.add(Integer.parseInt(q));
			
			Collections.sort(s);
			sb.append(s.get(0)+" "+s.get(t-1)+"\n");
		}
		
		System.out.print(sb.toString());
	}
}
