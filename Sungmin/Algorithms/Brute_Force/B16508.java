/*
 * 조합 특. 한 번의 정탐색으로 모든 경우를 찾을 수 있음
 * 브루트 포스하면 순열 아니면 조합을 이용한 게 되게 많구나
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B16508 {
	static int min=-1;
	static int[] comb=new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String obj=input.readLine();
		int[] objal=new int[26];
		for(int i=0;i<obj.length();i++)
			objal[obj.charAt(i)-65]++;
		
		int n=Integer.parseInt(input.readLine());
		int[] prices=new int[n];
		int[][] nameal=new int[n][26];
		for(int i=0;i<n;i++) {
			StringTokenizer stk=new StringTokenizer(input.readLine());
			prices[i]=Integer.parseInt(stk.nextToken());
			String temp=stk.nextToken();
			for(int i1=0;i1<temp.length();i1++)
				nameal[i][temp.charAt(i1)-65]++;
		}
		int digit=0;
		while(digit<n) {
			digit++;
			boolean[] visited=new boolean[n];
			combination(visited,objal,nameal,prices,n,digit,0);
		}
		System.out.print(min);
		input.close();
	}
	static void combination(boolean[] visited,int[] objal, int[][]nameal, int[] prices,int n,int r,int start) {
		if(r==0) {
			int tempprice=0;
			int[] tempobjal=new int[26];
			for(int i=0;i<26;i++)
				tempobjal[i]=objal[i];//하드카피
			for(int i=0;i<n;i++) {
				if(!visited[i])continue;
				tempprice+=prices[i];
				for(int i1=0;i1<nameal[i].length;i1++)
					tempobjal[i1]-=nameal[i][i1];
			}
			for(int i=0;i<26;i++) {
				if(tempobjal[i]>0) return;
			}
			if(min==-1) min=tempprice;
			else if(tempprice<min) min=tempprice;
			return;
		}
		for(int i=start;i<n;i++) {
			visited[i]=true;
			combination(visited,objal,nameal,prices,n,r-1,i+1);
			visited[i]=false;
		}
	}
}