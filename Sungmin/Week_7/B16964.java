import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class B16964 {
	static int compareindex=1;
	static StringBuilder sb = new StringBuilder();
	static int[] compare;
	static boolean flag=true;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			int vertex=Integer.parseInt(input.readLine());
			int edge=vertex-1;
			int start=1;
			boolean[] visited = new boolean[vertex+1];
			ArrayList<Integer>[] graph = new ArrayList[vertex+1];
			compare = new int[vertex];
			for(int i=0;i<vertex+1;i++) graph[i]=new ArrayList<Integer>();//temp[0]에 1이 들어가있는 거
			for(int i=0;i<edge;i++) {
				String[] temp2 = input.readLine().split(" ");
				int x=Integer.parseInt(temp2[0]);
				int y=Integer.parseInt(temp2[1]);
				graph[x].add(y);
				graph[y].add(x);
			}
			String[] s = input.readLine().split(" ");
			for(int i=0;i<vertex;i++) compare[i]=Integer.parseInt(s[i]);
			if(compare[0]!=1) flag=false;
			else dfs(graph,visited,start);
			if(flag) System.out.print("1");
			else System.out.print("0");
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
		if(visited[start]) return;
		visited[start]=true;
		HashSet<Integer> set = new HashSet<>();
		//HashSet 처음 써봄. contatis라는 개꿀 함수가 있었구나
		for(int y : graph[start]) {
			if(visited[y])continue;
			set.add(y);
		}
		if(set.size()==0)return;
		if(set.contains(compare[compareindex]))dfs(graph,visited,compare[compareindex++]);
		else flag=false;
	}
}