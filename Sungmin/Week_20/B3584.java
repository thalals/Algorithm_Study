import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
public class B3584 {
	static int result=0;
	static ArrayList<ArrayList<Integer>> tree;
	public static void main(String[] args) throws IOException{
		StringBuilder sb=new StringBuilder();
		tree=new ArrayList<ArrayList<Integer>>();
		Stack<Integer> stack=new Stack<Integer>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(input.readLine());
		for(int i=0;i<num;i++) {
			int n=Integer.parseInt(input.readLine());
			tree.clear();
			stack.clear();
			boolean[] visited=new boolean[n+1];
			for(int i1=0;i1<=n;i1++) tree.add(new ArrayList<Integer>());
			for(int i1=0;i1<n-1;i1++) {
				String[] s=input.readLine().split(" ");
				int par=Integer.parseInt(s[0]);
				int child=Integer.parseInt(s[1]);
				tree.get(child).add(par);//바텀업 구조
			}
			String[] s=input.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			stack.add(start);
			while(!stack.isEmpty()) {
				int node=stack.pop();
				visited[node]=true;
				for(int i1=0;i1<tree.get(node).size();i1++)
					stack.add(tree.get(node).get(i1));
			}//start가 지나간 길 visited로 발라놓기
			stack.add(end);
			while(!stack.isEmpty()) {
				int node=stack.pop();
				if(visited[node]) {//처음 만나는 visited=true 구가 첫 공통 조상일 것임
					sb.append(node+"\n");
					break;
				}
				visited[node]=true;
				for(int i1=0;i1<tree.get(node).size();i1++)
					stack.add(tree.get(node).get(i1));
			}
		}
		System.out.print(sb);
		input.close();
	}
}