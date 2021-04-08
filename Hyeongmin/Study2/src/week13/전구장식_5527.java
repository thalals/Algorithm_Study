package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구장식_5527 {
	static int originLamp[];
	static int Lamp[];
	
	static int result=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");
		
		originLamp = new int[n];
		Lamp = new int [n];
		for(int i=0; i<n;i++) {
			originLamp[i] = Integer.parseInt(temp[i]);
			Lamp[i] = Integer.parseInt(temp[i]);
		}
		/*--------------input-----------*/
		
		result = patternCheck(originLamp);
		
		//어디부터
		for(int startPoint=0;startPoint<n;startPoint++) {
			//어디까지
			for(int endPoint=0;endPoint<n;endPoint++) {
				changeLamp(startPoint, endPoint);
				int patterncount = patternCheck(Lamp);
				result = Math.max(result, patterncount);
				init();
			}
		}
		
		System.out.println(result);
	}
	
	//초기화
	public static void init() {
		for(int i=0;i<originLamp.length;i++)
			Lamp[i] = originLamp[i];
	}
	
	//전구 바꾸기
	public static void changeLamp(int start, int end) {
		
		for(int i=start;i<=end;i++) {
			if(Lamp[i]==0)
				Lamp[i]=1;
			else
				Lamp[i]=0;
		}
	}
	
	//교대패턴 카운트
	public static int patternCheck(int temp[]) {
		int count=0;
		
		for(int i=0;i<temp.length-1;i++) {
			for(int j=i;j<temp.length-1;j++) {
				//교대 패턴이 아닐때
				if(temp[j]==temp[j+1]) {
					count=Math.max(count, (j-i)+1);
					i++;
					continue;
				}
				//교대 패턴일때
				else if(j==temp.length-1) {
					count=Math.max(count, (j-i)+1);
					i++;
				}
			}

		}
		return count;
	}
}
