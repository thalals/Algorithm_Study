package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;

public class ≈Î∞Ë«–_2108 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		int count_arr[] = new int[80003];
		
		double sum =0;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
			count_arr[arr[i]+4000]++;	//count_arr[0] = -4000;
			
		}
		int index =0;
		int max_bin = 0;
		
		ArrayList<Integer> bin_list = new ArrayList<Integer>();
		
		//Counting Sort
		for(int i=0;i<count_arr.length;i++) {
			int a = count_arr[i];
			
			if(max_bin<a) {
				max_bin = a;
				bin_list.clear();
				bin_list.add(-4000+i);
			}
			else if(max_bin==a) {
				if(bin_list.size()==1)
					bin_list.add(-4000+i);
			}
			
			for(int j=0;j<a;j++)
				arr[index++] = -4000+i;
		}
		
		
		int t = bin_list.get(0);
		if(bin_list.size()==2)
			t=bin_list.get(1);
		
		
		System.out.println(Math.round(sum/n));
		System.out.println(arr[(n/2)]);
		System.out.println(t);
		System.out.println(Math.abs(arr[n-1]-arr[0]));
		
		
	}

}
