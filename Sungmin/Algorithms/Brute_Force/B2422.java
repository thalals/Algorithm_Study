/*
 * 배제조건 개빡세네 이거. 입력조건에도 배제조건 붙어야되는 걸 나중에 알아버림
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B2422 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(input.readLine());
		int n=Integer.parseInt(stk.nextToken());
		int m=Integer.parseInt(stk.nextToken());
		int count=0;
		boolean[][] combination=new boolean[n+1][n+1];
		for(int i=1;i<=m;i++) {
			stk=new StringTokenizer(input.readLine());
			int x=Integer.parseInt(stk.nextToken());
			int y=Integer.parseInt(stk.nextToken());
			combination[x][y]=true;
			combination[y][x]=true;
		}
		for(int i=1;i<=n-2;i++) {
			for(int i1=i+1;i1<=n-1;i1++) {
				if(combination[i][i1])
					continue;
				for(int i2=i1+1;i2<=n;i2++) {
					if(combination[i][i2]||combination[i1][i2])
						continue;
					count++;
				}
			}
		}
		System.out.print(count);
		input.close();
	}
}