import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class B1967 {
	static class Node{
		int num;
		int dist;
		Node(int num, int dist){
			this.num=num;
			this.dist=dist;
		}
	}
	static boolean flag;
	static int result=0;
	static ArrayList<ArrayList<Node>> tree;
	public static void main(String[] args) throws IOException{
		tree=new ArrayList<ArrayList<Node>>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		boolean[] visited=new boolean[n+1];
		for(int i=0;i<=n;i++) tree.add(new ArrayList<Node>());
		for(int i=0;i<n-1;i++) {
			String[] s=input.readLine().split(" ");
			int par=Integer.parseInt(s[0]);
			int child=Integer.parseInt(s[1]);
			int dist=Integer.parseInt(s[2]);
			tree.get(par).add(new Node(child,dist));
			tree.get(child).add(new Node(par,dist));
		}
		for(int i=1;i<=n;i++) {
			for(int i1=i+1;i1<=n;i1++) {
				flag=false;
				dfs(visited, i, i1, 0);
				for(int i2=1;i2<=n;i2++) visited[i2]=false;
			}
		}
		System.out.print(result);
		input.close();
	}
	static void dfs(boolean[] visited, int start, int end, int sum) {
		visited[start]=true;
		if(start==end) {
			if(sum>result)result=sum;
			flag=true;
			return;
		}
		for(int i=0;i<tree.get(start).size();i++) {
			int y=tree.get(start).get(i).num;
			if(!visited[y])dfs(visited, y, end, sum+tree.get(start).get(i).dist);
			if(flag)return;
		}
	}
}