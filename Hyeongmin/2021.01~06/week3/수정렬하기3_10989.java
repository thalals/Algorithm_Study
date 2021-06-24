package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수정렬하기3_10989 {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		int count_arr[] = new int[10001];
		
		//카운팅
		for(int i=0;i<n;i++) 
			count_arr[arr[i]]+=1;
		
		for(int i=0;i<count_arr.length;i++) {
			int a = count_arr[i];
			for(int j=0;j<a;j++)
				bw.append(i+"\n");
		}
		
		bw.close();
		br.close();
	}

}
