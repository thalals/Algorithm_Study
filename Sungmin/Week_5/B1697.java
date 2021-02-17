import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1697 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s=input.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			int visited[] = new int [100001];
			int depth[] = new int [100001];
			
	        Queue<Integer> q = new LinkedList<Integer>();
			depth[start] = 0;
			visited[start] = 1;
			q.add(start);
			
			while (!q.isEmpty()){
				int vertex = q.poll();
				if (vertex<100000&&visited[vertex + 1]==0) {
					depth[vertex+1]=depth[vertex]+1;
					q.add(vertex+1);
					visited[vertex + 1] = 1;
					if(vertex+1==end) break;
				}
				if (vertex>0&&visited[vertex-1]==0) {
					depth[vertex-1]=depth[vertex]+1;
					q.add(vertex-1);
					visited[vertex-1] = 1;
					if(vertex-1==end) break;
				}
				if (vertex<=50000&&visited[vertex*2]==0) {
					depth[vertex*2]=depth[vertex]+1;
					q.add(vertex*2);
					visited[vertex*2]=1;
					if(vertex*2==end) break;
				}
			}
			System.out.println(depth[end]);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}