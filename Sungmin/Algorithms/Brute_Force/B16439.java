/*
 * n개의 치킨 중 3개의 치킨을 고르는 백트래킹(조합/dfs) 기법을 생각보다 많이 쓰는 것 같음
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B16439 {
	static int max=0;
	static int[] comb=new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(input.readLine());
		int n=Integer.parseInt(stk.nextToken());
		int m=Integer.parseInt(stk.nextToken());
		boolean[] visited=new boolean[m];
		int[][] prefer=new int[n][m];
		for(int i=0;i<n;i++) {
			stk=new StringTokenizer(input.readLine());
			for(int i1=0;i1<m;i1++)
				prefer[i][i1]=Integer.parseInt(stk.nextToken());
		}
		combination(visited,prefer,0,n,m);
		System.out.print(max);
		input.close();
	}
	static void combination(boolean[] visited,int[][] prefer,int index,int n,int m) {
		if(index==3) {
			int[] maxprefer=new int[n];
			int tempmax=0;
			for(int i=0;i<5;i++) {
				if(!visited[i])continue;
				for(int i1=0;i1<n;i1++) {
					if(maxprefer[i1]<prefer[i1][i])
						maxprefer[i1]=prefer[i1][i];
				}
			}
			for(int i=0;i<n;i++)
				tempmax+=maxprefer[i];
			if(tempmax>max)
				max=tempmax;
			return;
		}
		for(int i=0;i<m;i++) {
			if(visited[i])continue;
			visited[i]=true;
			combination(visited,prefer,index+1,n,m);
			visited[i]=false;
		}
	}
}