import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10997 {
	static StringBuilder sb=new StringBuilder();
	static String[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		int standard=4*n-3;
		int leftside=1;
		int rightside=standard;
		if(n==1) sb.append("*"+"\n");
		for(int i=1;i<=n;i++) {
			if(n==1) break;
			if(i==1) {
				for(int i1=1;i1<=standard;i1++)
					sb.append("*");
				sb.append("\n"+"*"+"\n");
				leftside+=2;
			}
			else {
				for(int i1=1;i1<=(leftside-1)/2;i1++)
					sb.append("* ");
				for(int i1=leftside;i1<=rightside;i1++)
					sb.append("*");
				for(int i1=1;i1<=(standard-rightside+1)/2;i1++)
					sb.append(" *");
				sb.append("\n");
				for(int i1=1;i1<=(leftside-1)/2;i1++)
					sb.append("* ");
				for(int i1=leftside;i1<=rightside;i1++) {
					if(i1==leftside||i1==rightside) sb.append("*");
					else sb.append(" ");
				}
				for(int i1=1;i1<=(standard-rightside+1)/2;i1++)
					sb.append(" *");
				sb.append("\n");
				leftside+=2;
				rightside-=2;
			}
		}
		leftside=standard/2+1;
		rightside=standard/2+1;
		for(int i=1;i<=n;i++) {
			if(n==1)break;
			if(i!=n) {
				for(int i1=1;i1<=(leftside-1)/2;i1++)
					sb.append("* ");
				for(int i1=leftside;i1<=rightside;i1++)
					sb.append("*");
				for(int i1=1;i1<=(standard-rightside+1)/2;i1++)
					sb.append(" *");
				sb.append("\n");
				leftside-=2;
				rightside+=2;
				for(int i1=1;i1<=(leftside-1)/2;i1++)
					sb.append("* ");
				for(int i1=leftside;i1<=rightside;i1++) {
					if(i1==leftside||i1==rightside) sb.append("*");
					else sb.append(" ");
				}
				for(int i1=1;i1<=(standard-rightside)/2;i1++)
					sb.append(" *");
				sb.append("\n");
			}
			else {
				for(int i1=1;i1<=standard;i1++)
					sb.append("*");
				sb.append("\n");
			}
		}
		System.out.print(sb);
		input.close();
	}
}