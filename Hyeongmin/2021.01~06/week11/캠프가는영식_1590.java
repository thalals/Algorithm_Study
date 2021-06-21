package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 캠프가는영식_1590 {
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int t = Integer.parseInt(temp[1]);
	
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			long buslist[] = new long[Integer.parseInt(temp[2])];
			int stopPoint = buslist.length;
			
			for(int j=0;j<buslist.length;j++) {
				buslist[j] = Integer.parseInt(temp[0]) + (j*Integer.parseInt(temp[1]));
				
				if(buslist[j]>=t) {
//					stopPoint = j;
					result = (int) Math.min(result, buslist[j]-t);

					break;
				}
			}
			
//			binarySearch(0, stopPoint, buslist, t);
//			int temp_result = mid_value - t;
			
//			result = Math.min(result, temp_result);
		}
		if(result==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static int mid_value = -1;
	
	static public void binarySearch(int start, int end, long buslist[], int key) {
		int mid = (start+end)/2;
		
		if(start>=end) {
			mid_value = (int)buslist[mid];
			if(buslist[mid]<key)
				mid_value = (int)buslist[mid+1];
			return;
		}
		
		if(buslist[mid] == key)  {
			mid_value = (int)buslist[mid];
			return;
		}
		
		
		
		if(buslist[mid]>key)
			binarySearch(start, mid-1, buslist, key);
		else
			binarySearch(mid+1, end, buslist, key);
		
		
	}
}
