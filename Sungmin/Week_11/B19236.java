import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B19236 {
	static int result=0;
	static class Board{
		int num;
		//1~16의 자연수
		int direction;
		//1이 위. 3이 왼쪽. 5가 아래. 7이 오른쪽. 최댓값은 8
		Board(int num, int direction){
			this.num=num;
			this.direction=direction;
		}
	}
	
	static class XY{
		int X;
		int Y;
		int num;
		int direction;
		XY(int num, int X, int Y,int direction){
			this.num=num;
			this.X=X;
			this.Y=Y;
			this.direction=direction;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		Board[][] fishbowl=new Board[4][4];
		XY[] sortarray=new XY[16];
		boolean[][] visited=new boolean[4][4];
		boolean[][] sharked=new boolean[4][4];
		for(int i=0;i<4;i++) {
			String[] s=input.readLine().split(" ");
			int count=0;
			for(int i1=0;i1<8;i1+=2) {
				fishbowl[i][count]=new Board(Integer.parseInt(s[i1]),Integer.parseInt(s[i1+1]));
				sortarray[Integer.parseInt(s[i1])-1]=new XY(Integer.parseInt(s[i1]),i,count,Integer.parseInt(s[i1+1]));
				count++;
			}
		}
		Board shark=new Board(0,0);
		shark.num+=fishbowl[0][0].num;
		shark.direction=fishbowl[0][0].direction;
		visited[0][0]=true;
		sharked[0][0]=true;
		FishMove(fishbowl, visited, sortarray, sharked);
		SharkJudge(fishbowl, visited, sharked, 0, 0, shark, sortarray);
		System.out.print(result);
		input.close();
	}
	
	public static void SharkJudge(Board[][] fishbowl, boolean[][] visited, boolean[][] sharked, int currentX, int currentY, Board shark, XY[] sortarray) {
		int[] dx= {-1,-1,0,1,1,1,0,-1};
		int[] dy= {0,-1,-1,-1,0,1,1,1};
		int index=shark.direction-1;
		int newX=currentX+dx[index];
		int newY=currentY+dy[index];
		while(true) {
			if(newX>=0&&newX<4&&newY>=0&&newY<4) {
				if(visited[newX][newY]) {
					newX+=dx[index];
					newY+=dy[index];
					continue;
				}
				else {//깊은복사
					Board[][] copyFishbowl=new Board[4][4];
					boolean[][] copyVisited=new boolean[4][4];
					boolean[][] copySharked=new boolean[4][4];
					XY[] copysortarray=new XY[16];
					for(int i=0;i<4;i++) {
						for(int i1=0;i1<4;i1++) {
							copyFishbowl[i][i1]=new Board(fishbowl[i][i1].num,fishbowl[i][i1].direction);
							copyVisited[i][i1]=visited[i][i1];
							copySharked[i][i1]=sharked[i][i1];
							copysortarray[copyFishbowl[i][i1].num-1]=new XY(copyFishbowl[i][i1].num,i,i1,copyFishbowl[i][i1].direction);
						}
					}
					//copysortarray=sortarray.clone();
					Board copyShark=new Board(shark.num,shark.direction);
					/*copyFishbowl[0][0].num=0;
					copyShark.num=0;
					copyVisited[3][0]=true;*/
					SharkMove(copyFishbowl, copyVisited, copySharked, currentX, currentY, newX, newY, copyShark);
					FishMove(copyFishbowl, copyVisited, copysortarray, copySharked);
					SharkJudge(copyFishbowl, copyVisited, copySharked, newX, newY, copyShark, copysortarray);
					newX+=dx[index];
					newY+=dy[index];
				}
			}
			else {
				result=Math.max(result, shark.num);
				break;
			}
				
		}

	}
	
	public static void SharkMove(Board[][] fishbowl, boolean[][] visited, boolean[][] sharked, int currentX, int currentY, int newX, int newY, Board shark) {
		sharked[currentX][currentY]=false;
		sharked[newX][newY]=true;
		
		visited[newX][newY]=true;
		
		shark.num+=fishbowl[newX][newY].num;
		shark.direction=fishbowl[newX][newY].direction;
	}
	
	public static void FishMove(Board[][] fishbowl, boolean[][] visited, XY[] sortarray, boolean[][] sharked) {
		int[] dx= {-1,-1,0,1,1,1,0,-1};
		int[] dy= {0,-1,-1,-1,0,1,1,1};
		for(int i=0;i<sortarray.length;i++) {
			int x=sortarray[i].X;
			int y=sortarray[i].Y;
			if(visited[x][y])continue;
			int count=0;
			for(int i1=sortarray[i].direction-1;count<8;count++) {
				if(i1==8) i1=0;
				int newX=x+dx[i1];
				int newY=y+dy[i1];
				if(newX>=0&&newX<4&&newY>=0&&newY<4&&!sharked[newX][newY]) {
					int tempnum=fishbowl[newX][newY].num;
					int tempdir=fishbowl[newX][newY].direction;
					int tempnum1=fishbowl[x][y].num;
					int tempdir1=i1+1;
					fishbowl[newX][newY].direction=tempdir1;
					fishbowl[newX][newY].num=tempnum1;
					fishbowl[x][y].direction=tempdir;
					fishbowl[x][y].num=tempnum;
					sortarray[fishbowl[newX][newY].num-1].X=newX;
					sortarray[fishbowl[newX][newY].num-1].Y=newY;
					sortarray[fishbowl[x][y].num-1].X=x;
					sortarray[fishbowl[x][y].num-1].Y=y;
					sortarray[fishbowl[newX][newY].num-1].direction=tempdir1;
					boolean flagtemp=visited[x][y];
					visited[x][y]=visited[newX][newY];
					visited[newX][newY]=flagtemp;
					/*for(int i2=0;i2<4;i2++) {
						for(int i3=0;i3<4;i3++) {
							System.out.print(fishbowl[i2][i3].num+" "+fishbowl[i2][i3].direction+" ");
						}
						System.out.print("\n");
					}
					System.out.print("\n");*/
					break;
				}
				i1++;
			}
		}
	}
}