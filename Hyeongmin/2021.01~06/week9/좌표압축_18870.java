package week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ÁÂÇ¥¾ÐÃà_18870 {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		String temp[] = br.readLine().split(" ");
		
		HashSet<Integer> ts = new HashSet<Integer>();
		
		for(int i=0;i<n;i++) {
			ts.add(Integer.parseInt(temp[i]));
		}
		
		result.addAll(ts);
		Collections.sort(result);
		
		for(String a : temp) {		
			binary(0,result.size()-1, Integer.parseInt(a));
			bw.write(count+ " ");
//			bw.append(Collections.binarySearch(result, Integer.parseInt(a))+" ");
			count=0;
		}
		
		br.close();
		bw.close();
		
	}
	
	static void binary(int start, int end, int key) {
		int mid = (start+end)/2;
		if(result.get(mid)==key) {
			count= mid;
			return;
		}
		
		if(mid<0 || mid>end || start==end)
			return;
		
		else{
			if(result.get(mid)>key)
				binary(start, mid, key);
			else
				binary(mid+1, end, key);
		}
		
		return;
	}
}
