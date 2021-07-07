import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B14503 {
	static int result=0;
	static class Robot{
		int direction;
		int X;
		int Y;
		Robot(int X, int Y, int direction){
			this.direction=direction;
			this.X=X;
			this.Y=Y;
		}
	}
	
	static void robotRotate(Robot R) {
		R.direction-=1;
		if(R.direction<0)R.direction+=4;
	}
	
	static void robotClean(Robot R, int[][] board) {
		if(board[R.X][R.Y]!=2) result++;
		board[R.X][R.Y]=2;
	}
	
	static void robotMove(Robot R) {
		if(R.direction==0) R.X--;
		else if(R.direction==1) R.Y++;
		else if(R.direction==2) R.X++;
		else R.Y--;
	}
	
	static void robotBack(Robot R) {
		if(R.direction==0) R.X++;
		else if(R.direction==1) R.Y--;
		else if(R.direction==2) R.X--;
		else R.Y++;
	}
	static int getRotate(Robot R) {
		if(R.direction==1)return 3;
		else if(R.direction==3)return 1;
		return R.direction;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] board=new int[N][M];
		
		s=input.readLine().split(" ");
		int r=Integer.parseInt(s[0]);
		int c=Integer.parseInt(s[1]);
		int d=Integer.parseInt(s[2]);
		Robot R=new Robot(r,c,d);
		
		for(int i=0;i<N;i++) {
			s=input.readLine().split(" ");
			for(int i1=0;i1<M;i1++) {
				board[i][i1]=Integer.parseInt(s[i1]);
			}
		}
		
		robotClean(R, board);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		int i=getRotate(R);
		int count=0;
		while(true) {
			i=(i+1)%4;
			int newX=R.X+dx[i];
			int newY=R.Y+dy[i];
			if(board[newX][newY]==0) {
				//닦을 수 있는 바닥
				robotRotate(R);
				robotMove(R);
				robotClean(R,board);
				i=getRotate(R);
				count=0;
			}
			else {
				//벽이거나 이미 닦은 경우
				if(count==4) {
					//한바퀴를 다 돌았을 경우
					robotBack(R);
					if(board[R.X][R.Y]==1)
						break;
					else {
						i=getRotate(R);
						count=0;
					}	
				}
				else{
					robotRotate(R);
					count++;
				}
				
			}
		}
		System.out.print(result);
		input.close();
	}
}