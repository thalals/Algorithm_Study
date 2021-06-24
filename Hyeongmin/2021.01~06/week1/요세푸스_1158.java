package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ¿ä¼¼Çª½º_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		Deque<Integer> dq = new ArrayDeque<Integer>();

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++)
			dq.offer(i);
		
		bw.append("<");

		while(dq.size()!=0) {
			for(int i=1;i<k;i++) {
				int tmp = dq.poll();	//¾Õ¿¡¼­ »©°í
				dq.offer(tmp);			// ´Ù½Ã µÚ·Î »ðÀÔ
			}
			if(dq.size()==1) 
				bw.append(dq.poll()+"");
			else
				bw.append(dq.poll()+","+" ");
		}
		bw.append(">");

		bw.flush();
		
		br.close();
		bw.close();

	}

}
