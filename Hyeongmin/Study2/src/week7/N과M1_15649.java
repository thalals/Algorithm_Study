package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class N과M1_15649 {
	static boolean visit[] ;
	static int result[];
	static int list[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		list = new int[n];
		
		for(int i =0;i<n;i++)
			list[i] = i+1;
		
		visit = new boolean[list.length];
		result = new int[m];
		
		int index =0;

		recursion(index);
		
	}
	
	public static void recursion(int index) {
		
		if(index == result.length) {
			for(int i=0;i<index;i++)
				System.out.print(result[i]+" ");
			System.out.println();
			
			return;
		}
		
		for(int i=0;i<list.length;i++) {
			//방문 안했으면
			if(!visit[i]) {
				result[index] = list[i];
				visit[i] = true;
				recursion(index+1);
				
				visit[i] = false;
			}
			
		}
	}

}
