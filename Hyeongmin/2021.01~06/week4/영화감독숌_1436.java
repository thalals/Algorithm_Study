package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 영화감독숌_1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		long min  = 666;
		int front_number = 1;
		int back_number =1;
		
//		for(int i=0;i<t;i++) {
//			long a = front_number_V(666, front_number);
//			long b = back_number_V(666,back_number);
//			
//			if(a<b) {
//				min =a;
//				front_number++;
//			}
//			else if(a>=b){
//				min=b;
//				back_number++;
//			}
//			else {	//같을때
//				min = b;
//				back_number++;
//			}
//		}
		int count =1;
		while(count<t) {
			min+=1;
			if((min+"").contains("666")) {
				count++;
			}
		}
		
		System.out.println(min);
		
		
		
	}
	static long front_number_V(long min, int front_number) {
		long result = (int)Math.pow(10,(min+"").length())*front_number + min;
		return result;
	}
	
	static long back_number_V(long min, int back_number) {
		long result =  (int)Math.pow(10,(back_number+"").length()) * min + back_number;
		return result;
	}

}
