package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 근손실_18429 {
	
	static int count=0;
	static boolean visit[];
	static int kit[];
	static int n,k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		n= Integer.parseInt(temp[0]);	//운동 키트 수
		k= Integer.parseInt(temp[1]); 	// 근손실 키로 수
		
		temp = br.readLine().split(" ");
		
		kit = new int[n+1];
		visit = new boolean[n+1];
		
		for(int i=0;i<temp.length;i++)
			kit[i+1] = Integer.parseInt(temp[i]);
		
		combination(0, 500);
		System.out.println(count);
	}
	
	public static void combination(int index, int muscle) {
		if(index==n) {
			count++;
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				if(kit[i]-k+muscle>=500) {
					muscle = muscle+ (kit[i] -k);
					visit[i] = true;
					combination(index+1, muscle);
					visit[i] =false;
					
					muscle = muscle- (kit[i] -k);

				}
			}
			
		}
	}

}
