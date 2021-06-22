package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¼ö¿­_2559 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		temp = br.readLine().split(" ");

		int maxTemp = 0, sum=0;

		int startidx = 0, endidx = m-1;
		
		for(int i=startidx;i<=endidx;i++) {
			maxTemp+=Integer.parseInt(temp[i]);
			sum+=Integer.parseInt(temp[i]);
		}
		
		while(++endidx<temp.length) {
			++startidx;
			
			sum-=Integer.parseInt(temp[startidx-1]);
			sum+=Integer.parseInt(temp[endidx]);
			
			maxTemp=Math.max(maxTemp, sum);
		}
		
		System.out.println(maxTemp);

	}

}
