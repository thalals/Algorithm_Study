package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기2_2751 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		arr = mergesort(arr);
		
		for(int q : arr)
			bw.append(q+"\n");
		bw.close();
		br.close();
	}
	
	public static int[] mergesort(int arr[]) {
		if(arr.length==1)
			return arr;
		
		int mid = arr.length/2;
		
		int left[] = new int[mid];
		int right[] = new int[arr.length-mid];
		
		for(int i=0;i<mid;i++)
			left[i] = arr[i];
		
		for(int i=0;i<right.length;i++)
			right[i] = arr[i+mid];
	
//		mergesort(left);
//		mergesort(right);
		
		arr = merge(mergesort(left),mergesort(right));
		return arr;
		
	}
	
	public static int[] merge(int left[], int right[]) {
		int count = left.length + right.length;
		
		int arr[] = new int[count];
		int a = 0,b=0;
		for(int i=0;i<count;i++) {
			if(left.length == a)
				arr[i] = right[b++];
			else if(right.length == b)
				arr[i] = left[a++];
			else if(left[a]<right[b])
				arr[i] = left[a++];
			else
				arr[i] = right[b++];
		}
		
		return arr;
	}

}
