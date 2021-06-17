package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class stuff{
	int weight;
	int value;
	
	stuff(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
	stuff(){};
}

public class 평범한배낭_12865 {
	
	public static ArrayList<stuff>bag = new ArrayList<stuff>();
	public static boolean visit[];
	public static int result =0,n,k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);	//버틸수 있는 무게
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			int w = Integer.parseInt(temp[0]);
			int v = Integer.parseInt(temp[1]);

			if(w>k)
				continue;
			
			stuff a = new stuff(w,v);
			bag.add(a);
		}
		
		visit = new boolean[bag.size()];
		/*-----------input----------*/
		
		for(int i=1;i<=bag.size();i++)
			check(0,i,0);
		
		System.out.println(result);
	}
	
	public static void check(int count, int size, int check_weight) {
		if(count == size) {
			int a=0;
			int sum=0;
			for(int i=0;i<bag.size();i++) {
				if(visit[i]) {
					sum += bag.get(i).value;
					check_weight+= bag.get(i).weight;
					a++;
				}
				if(a==size)
					break;
			}
			
			if(check_weight<=k)
				result = Math.max(result, sum);
			
			return;
		}
		
		for(int i=0;i<bag.size();i++) {
			boolean flag = false;
			if(!visit[i]) {
				check_weight +=bag.get(i).weight;
				if(check_weight<=k) {
					visit[i] = true;
					check(count+1,size,check_weight);
				}
				else {
					flag = true;
					check_weight -=bag.get(i).weight;
					continue;
				}
			}
			else if(!flag && visit[i]) {
				visit[i] = false;
				check_weight -=bag.get(i).weight;
			}

		}
	}
}
