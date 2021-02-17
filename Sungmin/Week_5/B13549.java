import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B13549 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s=input.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			int visited[] = new int [100001];
			int depth[] = new int [100001];
			
	        Queue<Integer> q = new LinkedList<Integer>();
	        Queue<Integer> qmuls = new LinkedList<Integer>();
			depth[start] = 0;
			visited[start] = 1;
			qmuls.add(start);
			
			while (!q.isEmpty()||!qmuls.isEmpty()){
				int vertex = qmuls.poll();
				
				if(vertex<=50000&&visited[vertex*2]==0) {
					depth[vertex*2]=depth[vertex];
					qmuls.add(vertex*2);
					visited[vertex*2]=1;
					if(vertex*2==end) break;
				}
				if(vertex<100000&&visited[vertex+1]==0) {
					depth[vertex+1]=depth[vertex]+1;
					q.add(vertex+1);
					visited[vertex + 1] = 1;
					if(vertex+1==end) break;
				}
				if(vertex>0&&visited[vertex-1]==0) {
					depth[vertex-1]=depth[vertex]+1;
					q.add(vertex-1);
					visited[vertex-1] = 1;
					if(vertex-1==end) break;
				}
				if(qmuls.isEmpty()&&!q.isEmpty()) {
					while(!q.isEmpty()) qmuls.add(q.poll());
				}
			}
			System.out.println(depth[end]);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}