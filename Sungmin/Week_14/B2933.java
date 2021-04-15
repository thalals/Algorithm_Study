//없어질 때마다 clustering되는지 조사
//-인접 좌표별 bfs시행하여 바닥을 만나는지 boolean값으로 조정(bfs 시행시 시행 좌표 모두 리스트에 저장)
//--boolean값이 바뀌지 않는다면(clustering이 false로 유지된다면) clustering작업 진행. false면 리스트 clear
//clustering 과정->cluster의 각 바닥 좌표를 도출. 각 바닥이 x/바닥을 언제 만나는지 최소 count
//최소 count 기준으로 리스트에 저장된 모든 값에서 x값을 빼줌
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B2933 {
	static boolean clustering=true;
	static int[][] board;
	static boolean[][] visited;
	static class XY implements Comparable<XY>{
		int x;
		int y;
		XY(int x, int y){
			this.x=x;
			this.y=y;
		}
		
		@Override
		public int compareTo(XY Word) {
			if(this.y<Word.y)return -1;
			else if(this.y==Word.y) {
				if(this.x<Word.x)return -1;
				else if(this.x==Word.x)return 0;
			}
			return 1;
		}
	}
	static Queue<XY> queue= new LinkedList<XY>();
	static ArrayList<XY> clusterQueue=new ArrayList<XY>();
	static ArrayList<XY> clusterFloor=new ArrayList<XY>();
	static ArrayList<XY> clusterDir=new ArrayList<XY>();
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s= input.readLine().split(" ");
		int r=Integer.parseInt(s[0]);
		int c=Integer.parseInt(s[1]);
		visited=new boolean[r+1][c+1];
		board=new int[r+1][c+1];
		for(int i=r;i>0;i--) {
			s=input.readLine().split("");
			for(int i1=0;i1<c;i1++) {
				if(s[i1].equals("."))board[i][i1+1]=0;
				else board[i][i1+1]=1;
				//미네랄 칸이 1, 빈 칸이 0
			}
		}
		//돌던지기 시작
		int rockCount=Integer.parseInt(input.readLine());
		s=input.readLine().split(" ");
		for(int i=0;i<rockCount;i++) {
			int x=Integer.parseInt(s[i]);
			if(i%2==0) {//왼쪽에서 오른쪽으로
				for(int i1=1;i1<=c;i1++) {
					if(rockJudge(x,i1,r,c))
						break;
				}
			}
			else {//오른쪽에서 왼쪽으로
				for(int i1=c;i1>=1;i1--) {
					if(rockJudge(x,i1,r,c))
						break;
				}
			}
			//print(r,c);
		}
		print(r,c);
		input.close();
	}
	
	static void bfs(int x, int y, int r, int c) {
		int[] dx= {-1,0,0,1};
		int[] dy= {0,-1,1,0};
		while(!queue.isEmpty()) {
			XY temp=queue.poll();
			if(temp.x==1) {
				clustering=false;
				return;
			}
			clusterQueue.add(new XY(temp.x,temp.y));
			for(int i=0;i<4;i++) {
				int newX=temp.x+dx[i];
				int newY=temp.y+dy[i];
				if(newX>=1&&newX<=r&&newY>=1&&newY<=c&&!visited[newX][newY]&&board[newX][newY]==1) {//유효성 검사
					visited[newX][newY]=true;
					queue.add(new XY(newX, newY));
				}
			}
		}
	}
	
	static boolean rockJudge(int x, int i1, int r, int c) {
		//한 번 막대기가 적중을 하면->적중 위치 기준으로 4방향 검사. 4방향에 미네랄이 있는 경우 임시큐//클러스터 큐에 저장을 먼저 한 다음에
		//클러스터 큐에 저장된 좌표 하나하나씩 bfs적용
		if(board[x][i1]==1) {
			board[x][i1]=0;
			visited[x][i1]=true;
			int[] dx= {-1,0,0,1};
			int[] dy= {0,-1,1,0};
			for(int i=0;i<4;i++) {
				int newX=x+dx[i];
				int newY=i1+dy[i];
				if(newX>=1&&newX<=r&&newY>=1&&newY<=c&&board[newX][newY]==1) {//유효성 검사
					clusterDir.add(new XY(newX,newY));
				}
			}
			for(int i=0;i<clusterDir.size();i++) {
				queue.add(new XY(clusterDir.get(i).x,clusterDir.get(i).y));
				visited[clusterDir.get(i).x][clusterDir.get(i).y]=true;
				bfs(x,i1,r,c);
				if(clustering) {
					cluster();
					//분리 작업 시작 함수 추가
					queue.clear();
					clusterQueue.clear();
					clusterFloor.clear();
					visited=new boolean[r+1][c+1];
					break;//이거 어떠헥 섬기;ㅏ서시;
				}
				else clustering=true;//분리되지 않음
				queue.clear();
				clusterQueue.clear();
				clusterFloor.clear();
				visited=new boolean[r+1][c+1];
			}
			clusterDir.clear();
			return true;
		}
		return false;
	}
	
	static void cluster() {
		findFloor();
		int count=0;
		while(true) {
			count++;
			for(int i=0;i<clusterFloor.size();i++) {
				XY temp=clusterFloor.get(i);
				if(temp.x-count==1||(temp.x-count>=2&&board[temp.x-count-1][temp.y]==1)) {
					//1. 바닥을 만났을 경우 또는 2. 미네랄을 만났을 경우
					makingFloor(count);
					return;
				}
			}
		}
	}
	
	static void findFloor() {//바닥 좌표 찾기+보드에서 클러스터 삭제(나중에 다시 찍어야 됨)
		Collections.sort(clusterQueue);
		int indexY=-1;
		for(int i=0;i<clusterQueue.size();i++) {
			XY temp=clusterQueue.get(i);
			board[temp.x][temp.y]=0;
			if(temp.y==indexY)
				continue;
			indexY=clusterQueue.get(i).y;
			clusterFloor.add(new XY(temp.x,temp.y));
		}
	}
	
	static void makingFloor(int count) {
		for(int i=0;i<clusterQueue.size();i++) {
			if(board[clusterQueue.get(i).x-count][clusterQueue.get(i).y]==1)
				System.out.print("Error");
			board[clusterQueue.get(i).x-count][clusterQueue.get(i).y]=1;
		}
			
	}
	
	static void print(int r, int c) {
		for(int i=r;i>0;i--) {
			for(int i1=1;i1<=c;i1++) {
				if(board[i][i1]==0)sb.append(".");
				else sb.append("x");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
