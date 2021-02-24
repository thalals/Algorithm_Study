package week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Arrays;

public class ¼öÃ£±â_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		String temp[] = br.readLine().split(" ");

		int bn[] = new int[n];

		for (int i = 0; i < n; i++)
			bn[i] = Integer.parseInt(temp[i]);

		int m = Integer.parseInt(br.readLine());

		temp = br.readLine().split(" ");

		int bm[] = new int[m];

		for (int i = 0; i < m; i++)
			bm[i] = Integer.parseInt(temp[i]);

		Arrays.sort(bn);
		
		
		for(int i=0;i<m;i++)
			bw.append(search(0,n-1,bm[i],bn)+"\n");
		
		bw.close();
		br.close();
		
	}	
	
	static public int search(int start, int end, int input, int result[]) {
		int mid = (start+end)/2;
		
		if(start>end)
			return 0;
		
		
		if(result[mid] == input)
			return 1;
		else if(result[mid]<input)
			return search(mid+1,end,input,result);
		else
			return search(start,mid-1,input,result);
	}

}
