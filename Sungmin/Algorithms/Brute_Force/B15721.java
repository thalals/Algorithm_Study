/*
 * 贱霸烙 必区
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B15721 {
	static boolean stop=false;
	static int circle=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(input.readLine());
		int t=Integer.parseInt(input.readLine());
		int flag=Integer.parseInt(input.readLine());//0=环, 1=单扁
		int[] count=new int[2];
		int buncount=1;
		while(true) {
			buncount++;
			for(int i=0;i<2;i++) {
				count[0]++;
				if(flag==0&&count[0]==t) {
					 System.out.print((count[0]+count[1]-1)%a);
					 return;
				}
				count[1]++;
				if(flag==1&&count[1]==t) {
					 System.out.print((count[0]+count[1]-1)%a);
					 return;
				}
			}
			if(stop)break;
			for(int i=0;i<buncount;i++) {
				count[0]++;
				if(flag==0&&count[0]==t) {
					 System.out.print((count[0]+count[1]-1)%a);
					 return;
				}
			}
			for(int i=0;i<buncount;i++) {
				count[1]++;
				if(flag==1&&count[1]==t) {
					 System.out.print((count[0]+count[1]-1)%a);
					 return;
				}
			}
		}
		input.close();
	}
	static boolean result(int flag, int[] count,int t,int circle) {
		if((flag==0&&count[0]==t)||(flag==1&&count[1]==t)) {
			stop=true;
			System.out.print(circle);
			return true;
		}
		return false;	
	}
	static void circling(int a) {
		circle++;
		if(circle==a)
			circle=0;
	}
}