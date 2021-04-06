import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B16235 {
	static ArrayList<Tree> trees=new ArrayList<Tree>();
	static ArrayList<Tree> ageFive=new ArrayList<Tree>();
	static ArrayList<Integer> index=new ArrayList<Integer>();
	static int result;
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		boolean died;
		Tree(int x, int y, int age){
			this.x=x;
			this.y=y;
			this.age=age;
			this.died=false;
		}
		
		@Override
		public int compareTo(Tree Word) {
			if(this.age<Word.age)return -1;
			else if(this.age==Word.age) return 0;
			return 1;
		}
		
	}
	
	static void spring(int[][] board) {
		for(int i=0;i<trees.size();i++) {
			if(trees.get(i).died) continue;
			if(board[trees.get(i).x][trees.get(i).y]>=trees.get(i).age) {
				//먹을 수 있음
				board[trees.get(i).x][trees.get(i).y]-=trees.get(i).age++;
				if(trees.get(i).age%5==0)//다섯쨜은 가을에 써야됨
					ageFive.add(trees.get(i));
			}
			else {
				//못먹으면 뒤짐
				index.add(i);
			}
		}
	}
	
	static void summer(int[][] board) {
		for(int i=0;i<index.size();i++) {
			int deleteindex=index.get(i);
			board[trees.get(deleteindex).x][trees.get(deleteindex).y]+=(trees.get(deleteindex).age/2);
			trees.get(deleteindex).died=true;
			result--;
		}
		index.clear();
	}
	
	static void autumn(int n) {//번식
		int[] dx= {-1,-1,-1,0,0,1,1,1};
		int[] dy= {-1,0,1,-1,1,-1,0,1};
		for(int i=0;i<ageFive.size();i++) {
			Tree temp=ageFive.get(i);
			for(int i1=0;i1<8;i1++) {
				int newX=temp.x+dx[i1];
				int newY=temp.y+dy[i1];
				if(newX>=1&&newX<=n&&newY>=1&&newY<=n) {//유효성 검사
					trees.add(0, new Tree(newX,newY,1));
					result++;
				}
			}
		}
		ageFive.clear();
	}
	
	static void winter(int[][] board, int[][] foodBoard, int n) {
		for(int i=1;i<=n;i++) {
			for(int i1=1;i1<=n;i1++) {
				board[i][i1]+=foodBoard[i][i1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);//배열 크기
		int m=Integer.parseInt(s[1]);//나무 개수
		int k=Integer.parseInt(s[2]);//몇년 트리거
		int[][] board=new int[n+1][n+1];//땅
		ArrayList<Tree> trees[][]=new ArrayList[n+1][n+1];
		int[][] foodBoard=new int[n+1][n+1];//거름 정보
		for(int i=1;i<=n;i++) {
			s=input.readLine().split(" ");
			for(int i1=1;i1<=n;i1++) {
				foodBoard[i][i1]=Integer.parseInt(s[i1-1]);
				board[i][i1]=5;
				trees[i][i1]=new ArrayList<Tree>();
			}
		}
		/*for(int i=0;i<m;i++) {
			s=input.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			int age=Integer.parseInt(s[2]);
			trees.add(new Tree(x,y,age));
		}
		Collections.sort(trees);
		result+=trees.size();
		//입력완료
		
		int count=0;
		while(count!=k) {
			spring(board);
			summer(board);
			autumn(n);
			winter(board, foodBoard, n);
			count++;
		}*/
		
		
		System.out.print(result);
		input.close();
	}
}