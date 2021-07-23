package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Egg{
	int w;
	int s;
	int index = -1;
	
	Egg(int s, int w){
		this.s = s;
		this.w = w;
	}
	
	Egg(int s, int w, int index){
		this.s = s;
		this.w = w;
		this.index = index;
	}
}

public class boj16987_계란으로계란치기 {
	
	static int egg;
	static Egg[] egglist;
	static int result = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		egg = Integer.parseInt(br.readLine());
		
		egglist = new Egg[egg];
		Egg[] list_Temp = new Egg[egg];

		for(int i=0;i<egg;i++) {
			String temp[] = br.readLine().split(" ");
			int s = Integer.parseInt(temp[0]);
			int w = Integer.parseInt(temp[1]);
			
			Egg e = new Egg(s,w,i);
			Egg et = new Egg(s,w,i);
			egglist[i] = e;		
			list_Temp[i] =et;
		}
		
		// input
		dfs(0, 0, list_Temp);
		System.out.println(result);
	}
	
	//cnt = 들고있는 계란의 인덱스
	public static void dfs(int cnt, int count, Egg[] list) {
		//다 조회 한 후
		if(cnt == egg) {
			if(count>result)
				result = count;
			return;
		}
		
		//들고있는 계란이 깨짐 or 다깨짐
		if(list[cnt].s<=0 || count == egg-1)
			dfs(cnt+1, count, list);
		
		int count_h = count;
		
		//cnt 로 egglist[i]를 때림
		for(int i=0; i<egg;i++) {
			if(list[i].s<=0 || list[cnt].s <=0||cnt == i)
				continue;
			
			//치고
			list = hitEgg(list[cnt], list[i], list);
			
			count_h = list[i].s <=0 ? count_h+1 : count_h;
			count_h= list[cnt].s <=0 ? count_h+1 : count_h;
			
			dfs(cnt+1, count_h, list);
			
			// 회복하고
			list[cnt].s = egglist[cnt].s;
			list[i].s = egglist[i].s;
			count_h = count;
			
		}
//		dfs(cnt+1, count_h, list);

	}
	
	public static Egg[] hitEgg(Egg e1, Egg e2, Egg[] list) {
		int e1_s = e1.s - e2.w;
		int e2_s = e2.s - e1.w;
		
		list[e1.index].s = e1_s;
		list[e2.index].s = e2_s ;
		
		return list;
	}
	
	

}
