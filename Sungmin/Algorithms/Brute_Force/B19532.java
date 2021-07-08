import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B19532 {
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		int[] arrays=new int[6];
		boolean flag=false;
		for(int i=0;i<6;i++) arrays[i]=Integer.parseInt(stk.nextToken());
		for(int i=-999;i<=999;i++) {
			for(int i1=-999;i1<=999;i1++) {
				if(arrays[0]*i+arrays[1]*i1==arrays[2]&&arrays[3]*i+arrays[4]*i1==arrays[5]) {
					System.out.print(i+" "+i1);
					flag=true;
					break;
				}
			}
			if(flag)break;
		}
		
		input.close();
	}
}