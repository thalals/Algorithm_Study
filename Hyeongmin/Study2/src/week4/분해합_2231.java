package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ºÐÇØÇÕ_2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split("");
		
		int n = 0;
		
		for(int i =0;i<temp.length;i++) {
			int number = Integer.parseInt(temp[temp.length-i-1])*(int)Math.pow(10, i);
			n = n+number;
		}
		
		int start = n - 9*temp.length;
		
		
		for(int i = start;i<=n;i++) {
			int sum = i;
			int number = i;
			
			while(number>0) {
				sum = sum+number%10;
				number/=10;
			}
			
			if(sum==n) {
				System.out.println(i);
				return;
			}
				
		}
		
		System.out.println(0);
		return;		
	}

}
