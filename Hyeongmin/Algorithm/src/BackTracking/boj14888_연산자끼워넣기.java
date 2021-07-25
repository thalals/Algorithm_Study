package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14888_연산자끼워넣기 {
	
	static int Number_list[];
	static int Operator[] = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Number_list = new int[n];
		
		String temp[] = br.readLine().split(" ");
		
		for(int i =0;i<n;i++)
			Number_list[i] = Integer.parseInt(temp[i]);
		
		temp= br.readLine().split(" ");
		for(int i =0;i<temp.length;i++)
			Operator[i] = Integer.parseInt(temp[i]);
		
		dfs(0, Number_list[0]);
		
		System.out.println(max+"\n"+min);
		
	}
	
	//idx : numberlist_index
	public static void dfs (int idx, int result) {
		if(idx == n-1) {
			if(result > max)
				max = result;
			if(result < min)
				min = result;
		
			return;
		}
		
		int count = 0;
		int index =0;
		while(count<n-1 && index<4) {
			if(Operator[index] == 0) {
				index++;
				continue;
			}
			//사칙연산
			int ra = result;
			result = calculation(result,Number_list[idx+1],index);
			Operator[index] -=1;
			
			dfs(idx+1, result);
			Operator[index]+=1;
			
			index++;
			result = ra;
			count++;
		}
	}
	
	public static int calculation(int a, int b, int number) {
		int result = 0;
		
		switch (number) {
			case 0: {
				
				result = a+b;
				break;
			}
			case 1:{
				result = a-b;
				break;
			}
			case 2:{
				result = a*b;
				break;
			}
			case 3:{
				//하나가 음수일 때
				if(a*b<0) {
					result = -(Math.abs(a)/Math.abs(b));
					break;
				}
				result = a/b;
				break;	
			}
		}
		
		return result;
	}
}
