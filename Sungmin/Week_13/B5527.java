import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5527 {
	
	static int start(int[] board, int cali) {//cali가 0이면 시작이 꺼짐, 1이면 시작이 켜짐
		int rightCount=0;//제대로 맞을 경우
		boolean changeFlagOne=false;//처음 틀리는 경우 플래그
		boolean changeFlagTwo=false;//틀렸다 맞았다 틀렸을 때의 개수를 세야함
		int count=0;//총 카운트
		int max=0;
		for(int i=0;i<board.length;i++) {
			int i1=(i+cali)%2;
			if(board[i]==i1) {//전구가 맞음
				if(changeFlagOne&&!changeFlagTwo) {//한 번 바뀐 상태면 여기서 끊김
					changeFlagTwo=true;
					count++;
					rightCount=1;
				}
				else {//단순 카운트 업
					rightCount++;
					count++;
				}
			}
			else {//전구가 틀림
				if(!changeFlagOne) {//처음 틀리는 거임
					changeFlagOne=true;
					count=1+rightCount;
					rightCount=0;
				}
				else {//처음 틀리는 게 아님
					if(changeFlagTwo) {//틀렸다 맞았다가 다시 틀림
						changeFlagOne=true;
						changeFlagTwo=false;
						max=Math.max(max, count);
						count=1+rightCount;
						rightCount=0;
					}
					else {//처음 틀리는 게 계속 유지중
						count++;
					}
				}
			}
		}
		return Math.max(max, count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		String[] s=input.readLine().split(" ");
		int[] board=new int[n];
		for(int i=0;i<n;i++)
			board[i]=Integer.parseInt(s[i]);
		//입력 완료
		System.out.print(Math.max(start(board,0), start(board,1)));
		input.close();
	}
}