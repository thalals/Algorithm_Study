import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B2667 {
	static StringBuilder sb = new StringBuilder();
	static boolean visited[][];
	static int house[][];
	static ArrayList<Integer> count = new ArrayList<Integer>();
	static int housecount;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			int vertex=Integer.parseInt(input.readLine());
			visited = new boolean[vertex+1][vertex+1];
			house = new int[vertex+1][vertex+1];
			for(int i=1;i<vertex+1;i++) {
				String[] temp = input.readLine().split("");
				for(int i1=1;i1<temp.length+1;i1++) {
					house[i][i1]=Integer.parseInt(temp[i1-1]);
				}
			}//하우스 입력 배열
			for(int i=1;i<vertex+1;i++) {
				for(int i1=1;i1<vertex+1;i1++) {
					if(visited[i][i1]) continue;
					if(house[i][i1]==1) {
						housecount=0;
						dfs(i,i1,vertex);
						count.add(housecount);
					}
				}
			}
			Collections.sort(count);
			sb.append(count.size()+"\n");
			for(int i=0;i<count.size();i++)sb.append(count.get(i)+"\n");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void dfs(int x, int y, int size) {
		visited[x][y]=true;
		housecount++;
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		for(int i=0;i<4;i++) {
			int newX=x+dx[i];
			int newY=y+dy[i];
			if(newX>=1&&newX<=size&&newY>=1&&newY<=size&&!visited[newX][newY]&&house[newX][newY]==1) {
				dfs(newX, newY, size);
			}	
		}
	}
}