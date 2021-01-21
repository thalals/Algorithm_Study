import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B1260 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s = input.readLine().split(" ");
			int vertex=Integer.parseInt(s[0]);
			int edge=Integer.parseInt(s[1]);
			int start=Integer.parseInt(s[2]);
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
			System.out.print(sb);
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