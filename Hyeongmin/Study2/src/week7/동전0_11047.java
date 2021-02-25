package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class µ¿Àü0_11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		 
		Stack<Integer> money = new Stack<Integer>();
		int count =0;
		int sum = 0;
		int n= Integer.parseInt(temp[0]);
		int k= Integer.parseInt(temp[1]);
		
		for(int i=0;i<n;i++) {
			int don = Integer.parseInt(br.readLine());
			money.push(don);
			if(don>k)
				continue;
		}
		
		int result = k;	//³²Àº µ·
		while(sum!=k) {
			int temp_money = money.pop();
			count = count + result/temp_money;
			sum = sum + temp_money*(result/temp_money);
			
			result-=temp_money*(result/temp_money);
		}	
		
		System.out.println(count);
	}

}
