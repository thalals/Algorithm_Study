import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B1018 {
	static class Board{
		//개별 정사각형에 색칠될 정보를 각각 집어넣기 위해 생성한 클래스
		int countW;//해당 정사각형이 흰색 방법에서 칠해지면 +1
		int countB;//해당 정사각형이 검은색 방법에서 칠해지면 +1
		Board(){
			this.countB=0;
			this.countW=0;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			String[] s = input.readLine().split(" ");
			int countW=0;
			int countB=0;
			int minCount;
			int x = Integer.valueOf(s[0]);
			int y = Integer.valueOf(s[1]);
			Board[][] array = new Board[x][y];
			for(int i=0;i<x;i++) {
				for(int i1=0;i1<y;i1++)
					array[i][i1]=new Board();
			}
			for(int i=0;i<x;i++) {
				String temp=input.readLine();
				//i%2=1이면 두번째 칸, 0이면 첫번째 칸
				//처음이 하얀색일 때부터
				if(i%2==0) {
					for(int i1=0;i1<y;i1++) {
						if(i1%2==0) {
							if(temp.charAt(i1)=='B') array[i][i1].countW++;
							else if(temp.charAt(i1)=='W') array[i][i1].countB++;
						}
						else if(i1%2==1) {
							if(temp.charAt(i1)=='W') array[i][i1].countW++;
							else if(temp.charAt(i1)=='B') array[i][i1].countB++;
						}
					}
				}
				else {
					for(int i1=0;i1<y;i1++) {
						if(i1%2==0) {
							if(temp.charAt(i1)=='W') array[i][i1].countW++;
							else if(temp.charAt(i1)=='B') array[i][i1].countB++;
						}
						else if(i1%2==1) {
							if(temp.charAt(i1)=='B') array[i][i1].countW++;
							else if(temp.charAt(i1)=='W') array[i][i1].countB++;
						}
					}
				}
			}
			//지금까지 받은 모든 입력을 X*Y개의 클래스 정보로 치환한다.
			//아래는 충격과 공포의 4중 for문
			minCount=x*y;
			for(int i=0;i<x-7;i++) {
				for(int i1=0;i1<y-7;i1++) {
					for(int i2=i;i2<i+8;i2++) {
						for(int i3=i1;i3<i1+8;i3++) {
							countW+=array[i2][i3].countW;
							countB+=array[i2][i3].countB;
						}
					}
					if(countB>countW&&minCount>countW)minCount=countW;
					else if(countB<=countW&&minCount>countB)minCount=countB;
					countW=0;
					countB=0;
				}
			}
			output.write(String.valueOf(minCount));
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}