package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합2_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		temp = br.readLine().split(" ");

		int count = 0;

		int startidx = 0, endidx = 0;
		int sum = Integer.parseInt(temp[0]); // 초기 첫번째

		while (endidx < temp.length) {
			
			// M보다 작고 끝에 도달하지 않았을 때
			if (sum < m && endidx!=temp.length-1)
				sum+=Integer.parseInt(temp[++endidx]);
			// M보다 작지않을 때
			else {
				if (sum == m)
					count++;
				
				if (startidx == endidx ) {
					
						sum -= Integer.parseInt(temp[startidx++]); // 이전값 빼고
						if(++endidx<temp.length)
							sum += Integer.parseInt(temp[endidx]); // 다음값 추가
					
				} else
					sum-=Integer.parseInt(temp[startidx++]);	//한칸 앞으로 이전 값 빼기
			}
		}

		System.out.println(count);
	}


}
