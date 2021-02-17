import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B7576 {
	static StringBuilder sb = new StringBuilder();
	static boolean visited[][];
	static int dayVisited[][];
	static int tomato[][];
	static int daycount=0;
	static boolean changed;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s=input.readLine().split(" ");
			int y=Integer.parseInt(s[0]);
			int vertex=Integer.parseInt(s[1]);
			visited = new boolean[vertex+1][y+1];
			dayVisited = new int[vertex+1][y+1];
			tomato = new int[vertex+1][y+1];
			for(int i=1;i<vertex+1;i++) {
				String[] temp = input.readLine().split(" ");
				for(int i1=1;i1<y+1;i1++) {
					tomato[i][i1]=Integer.parseInt(temp[i1-1]);
				}
			}//토마토 입력 배열
			while(true) {
				changed=false;
				for(int i=1;i<vertex+1;i++) {
					for(int i1=1;i1<y+1;i1++) {
						if(tomato[i][i1]==1&&dayVisited[i][i1]==daycount) {
							dfs(i,i1,vertex,y);
						}
					}
				}
				if(!changed) break;
				else daycount++;
			}//검사
			for(int i=1;i<vertex+1;i++) {
				for(int i1=1;i1<y+1;i1++) {
					if(tomato[i][i1]==0) {
						System.out.print("-1");
						return;
					}
				}
			}//-1판단
			System.out.print(daycount);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void dfs(int x, int y, int sizeX, int sizeY) {
		visited[x][y]=true;
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		for(int i=0;i<4;i++) {
			int newX=x+dx[i];
			int newY=y+dy[i];
			if(newX>=1&&newX<=sizeX&&newY>=1&&newY<=sizeY&&!visited[newX][newY]&&tomato[newX][newY]==0) {
				changed=true;
				dayVisited[newX][newY]=daycount+1;
				tomato[newX][newY]=1;
			}	
		}
	}
}