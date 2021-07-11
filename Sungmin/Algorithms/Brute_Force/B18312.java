/*
 * 단순 구현 문제. 60진법 사용법만 익히면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B18312 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		int n=Integer.parseInt(stk.nextToken());
		int k=Integer.parseInt(stk.nextToken());
		int result=0;
		int[] time=new int[3];//0=hour, 1=minute, 2=second
		String[] stime=new String[3];
		while(true) {
			boolean flag=false;
			if(n+1==time[0]&&time[1]==0&&time[2]==0)
				break;
			for(int i=0;i<3;i++) {
				if(time[i]<10)
					stime[i]="0"+String.valueOf(time[i]);
				else
					stime[i]=String.valueOf(time[i]);
			}
			for(int i=0;i<3;i++) {
				for(int i1=0;i1<stime[i].length();i1++) {
					if((int)(stime[i].charAt(i1))-48==k) {
						flag=true;
						break;
					}
				}
				if(flag) {
					result++;
					break;
				}
			}
			time[2]++;
			if(time[2]==60) {
				time[2]=0;
				time[1]++;
				if(time[1]==60) {
					time[1]=0;
					time[0]++;
				}
			}
		}
		System.out.print(result);
		input.close();
	}
}