import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> leastqueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			int x=Integer.parseInt(input.readLine());
			if(i%2==0)//최대 힙에 들어감
				maxqueue.add(x);
			else//최소 힙에 들어감
				leastqueue.add(x);
			if(!leastqueue.isEmpty()&&maxqueue.peek()>leastqueue.peek()) {
				int temp1=maxqueue.peek();
				int temp2=leastqueue.peek();
				maxqueue.poll();
				leastqueue.poll();
				maxqueue.add(temp2);
				leastqueue.add(temp1);
			}
			sb.append(maxqueue.peek()+"\n");
		}
		System.out.print(sb);
		input.close();
	}
}
