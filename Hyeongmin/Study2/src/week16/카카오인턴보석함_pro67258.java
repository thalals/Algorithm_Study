package week16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 카카오인턴보석함_pro67258 {

	public static void main(String[] args) throws IOException{
		String gems[] = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		
		System.out.println(gems_list(gems));
		
		int result[] = solution(gems);
		System.out.println(result[0]+" "+result[1]);
	}
	
	public static int[] solution(String[] gems) throws IOException {
        int start=0,end=0;
        int size = Integer.MAX_VALUE;
        
		int[] answer = {start,end};
                
		HashSet<String> gemlist = gems_list(gems);	//보석 리스트
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		

		while(true) {
			hm.put(gems[end], hm.getOrDefault(gems[end], 0)+1);	//없으면 0 있으면 +1
			
			//모든 종류를 모았을 때
			while(hm.size()==gemlist.size()) {
				int range_size = (end-start)+1;

				if(size>range_size) {
					size = range_size;
					answer[0]=start;
					answer[1]=end;
				}
				
				//왼쪽 이동
				hm.put(gems[start], hm.get(gems[start])-1);
				if(hm.get(gems[start])==0)
					hm.remove(gems[start]);
				
				start+=1;
				
				if(start>end)
					break;
			}
			
			//오른쪽 이동
			end+=1;
			
			if(end>gems.length-1)
				break;
			
			
		}
		
        
		answer[0]++;
		answer[1]++;
        return answer;
    }
	
	
	public static HashSet<String> gems_list(String[] gems) {
		HashSet<String> list = new HashSet<String>();
		
		for(String gem :gems) {
			list.add(gem);
		}
		return list;
	}
}
