import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class B7576 {
	static StringBuilder sb = new StringBuilder();
	static boolean visited[][];
	static int dayVisited[][];
	static int tomato[][];
	static int daycount=-1;
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
			Queue<Integer> qx = new LinkedList<Integer>();
			Queue<Integer> qy = new LinkedList<Integer>();
			int dx[] = {0,1,0,-1};
			int dy[] = {1,0,-1,0};
			for(int i=1;i<vertex+1;i++) {
				for(int i1=1;i1<y+1;i1++) {
					if(tomato[i][i1]==1&&!visited[i][i1]) {
						dayVisited[i][i1]=1;
						visited[i][i1]=true;
						qx.add(i);
						qy.add(i1);
					}
				}
			}//처음 도마도만 큐에 담음
			while(!qx.isEmpty()) {
				int X=qx.poll();
				int Y=qy.poll();
				for(int i2=0;i2<4;i2++) {
					int newX=X+dx[i2];
					int newY=Y+dy[i2];
					if(newX>=1&&newX<=vertex&&newY>=1&&newY<=y&&!visited[newX][newY]&&tomato[newX][newY]==0) {
						tomato[newX][newY]=1;
						visited[newX][newY]=true;
						qx.add(newX);
						qy.add(newY);
						if(dayVisited[newX][newY]==0) dayVisited[newX][newY]=dayVisited[X][Y]+1;
						else if(dayVisited[newX][newY]>dayVisited[X][Y]+1) dayVisited[newX][newY]=dayVisited[X][Y]+1;
					}
				}
			}
			for(int i=1;i<vertex+1;i++) {
				for(int i1=1;i1<y+1;i1++) {
					if(!visited[i][i1]&&tomato[i][i1]==0) {
						System.out.print("-1");
						System.exit(0);
					}
					else if(dayVisited[i][i1]>daycount) daycount=dayVisited[i][i1];
				}
			}
			System.out.print(daycount-1);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}