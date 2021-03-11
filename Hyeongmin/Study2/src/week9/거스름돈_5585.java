package week9;

import java.io.*;
class °Å½º¸§µ·_5585 {

	public static void main(String[] args) throws IOException	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000-Integer.parseInt(br.readLine());
		
		int count=0;
		
		int a[] = {500,100,50,10,5,1};
		
		while(money>0) {
			int i=0;
			while(true) {
				if(money-a[i]>=0) {
					money-=a[i];
					count++;
					break;
				}
				else
					i++;
			}
		}
		
		System.out.println(count);
	}

}
