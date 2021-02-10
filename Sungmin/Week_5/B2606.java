import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B2606 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			int vertex=Integer.parseInt(input.readLine());
			int edge=Integer.parseInt(input.readLine());
			int start=1;
			int count=0;
			boolean[] visited = new boolean[vertex+1];
			ArrayList<Integer>[] graph = new ArrayList[vertex+1];
			for(int i=0;i<vertex+1;i++) graph[i]=new ArrayList<Integer>();//temp[0]에 1이 들어가있는 거
			for(int i=0;i<edge;i++) {
				String[] temp2 = input.readLine().split(" ");
				int x=Integer.parseInt(temp2[0]);
				int y=Integer.parseInt(temp2[1]);
				graph[x].add(y);
				graph[y].add(x);
			}
			for(int i=1;i<graph.length;i++)Collections.sort(graph[i]);
			dfs(graph, visited, start);
			for(int i=1;i<visited.length;i++) if(visited[i])count++;
			System.out.print(count-1);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
		visited[start]=true;
		sb.append(start+" ");
		for(int y : graph[start]) {
			if(!visited[y]) dfs(graph, visited, y);
		}
	}
}