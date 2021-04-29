package week16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Data implements Comparable<Data>{
	int number;
	int priority;
	
	Data(int number, int priority){
		this.number = number;
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Data o) {
		if(this.priority> o.priority)
			return 1;
		//우선순위가 같을때는 문제숫자별로
		else if(this.priority==o.priority) {
			if(this.number>o.number)
				return 1;
		}
		return-1;
	}
}
public class 문제집_1766 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		boolean visit[] = new boolean[n+1];	//1부터 시작
		
		PriorityQueue<Data> list = new PriorityQueue<Data>();
		
 		//m개의 먼저풀어야할 문제쌍
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			int number = Integer.parseInt(temp[0]);
			int backNumber = Integer.parseInt(temp[1]);

			visit[backNumber] = true;
			Data data = new Data(backNumber, number+1);	//바로뒤에 오는게 제일 효율이 좋음
			list.add(data);
		}
		
		for(int i=1;i<=n;i++) {
			if(visit[i])
				continue;
			
			visit[i]=true;
			Data data = new Data(i, i);	//바로뒤에 오는게 제일 효율이 좋음
			list.add(data);
		}
		
		while(!list.isEmpty()) {
			if(list.size()==1)
				bw.append(list.poll().number+"");
			else
				bw.append(list.poll().number+" ");
		}
		
		bw.close();
		br.close();
	}

}
