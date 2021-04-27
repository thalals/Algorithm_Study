import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class B7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		LinkedList<Integer> queue=new LinkedList<>();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			int count=Integer.parseInt(input.readLine());
			for(int i1=0;i1<count;i1++) {
				String[] s=input.readLine().split(" ");
				if(s[0].equals("I")) {//»ðÀÔ
					queue.add(Integer.parseInt(s[1]));
					Collections.sort(queue);
				}
				else {//Á¦°Å
					if(queue.isEmpty()) continue;
					if(s[1].equals("1"))
						queue.pollLast();
					else
						queue.pollFirst();
				}
			}
			if(queue.isEmpty())sb.append("EMPTY\n");
			else sb.append(queue.getLast()+" "+queue.getFirst()+"\n");
			queue.clear();
		}
		System.out.print(sb);
		input.close();
	}
}
