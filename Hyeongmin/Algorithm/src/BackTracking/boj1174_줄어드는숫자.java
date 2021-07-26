package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1174_줄어드는숫자 {
	//987654
	static int[] numberlist = {9,8,7,6,5,4,3,2,1,0};
	
	static ArrayList<Long> list= new ArrayList<Long>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dfs(0,0);
		
		Collections.sort(list);
		
		if(n>1023)
			System.out.println(-1);
		else
			System.out.println(list.get(n-1));
	}
	
	public static void dfs(long sum, int index) {
		if(!list.contains(sum))
			list.add(sum);
		
		if(index>=10)
			return;
		
		dfs((sum*10) + numberlist[index], index+1);
		dfs(sum,index+1);
	}
}
