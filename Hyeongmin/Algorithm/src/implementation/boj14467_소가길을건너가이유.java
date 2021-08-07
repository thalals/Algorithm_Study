package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj14467_소가길을건너가이유 {

	static int cow[] = new int[11];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String temp[];
		
		Arrays.fill(cow, -1);
		while(n-->0) {
			temp = br.readLine().split(" ");
			
			int idx = Integer.parseInt(temp[0]);
			int position = Integer.parseInt(temp[1]);
			
			if(cow[idx]==-1) 
				cow[idx]=position;
			else if(cow[idx]!=position){
				result++;
				cow[idx] = position;
			}
		}
	
		System.out.println(result);
	}
}
