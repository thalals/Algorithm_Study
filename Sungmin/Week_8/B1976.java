import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B1976 {
	static StringBuilder sb = new StringBuilder();
	static int citycount;
	static int cityplan;
	static int[] city;
	static int[] plan;
	static boolean flag=true;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			citycount=Integer.parseInt(input.readLine());
			city=new int[citycount+1];
			for(int i=1;i<=citycount;i++)city[i]=i;
			cityplan=Integer.parseInt(input.readLine());
			plan=new int[cityplan];
			for(int i=1;i<=citycount;i++) {
				String[] s=input.readLine().split(" ");
				for(int i1=i-1;i1<citycount;i1++) {
					if(s[i1].equals("1"))
						Union(i,i1+1);
				}
			}
			String[] s=input.readLine().split(" ");
			for(int i=0;i<cityplan;i++) plan[i]=Integer.parseInt(s[i]);
			for(int i=0;i<cityplan-1;i++) {
				if(!isSameParent(plan[i],plan[i+1])) {
					flag=false;
					break;
				}
			}
			if(flag)sb.append("YES");
			else sb.append("NO");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int Find(int x) {
		if(x==city[x]) return x;
		else return city[x]=Find(city[x]);
	}
	
	public static void Union(int x, int y) {
		x=Find(x);
		y=Find(y);
		if(x!=y)city[y]=x;//x의 값이 더 작다는 것을 암시.코드에서 큰 경우를 배제하였음.
	}
	
	public static boolean isSameParent(int x, int y) {
		x=Find(x);
		y=Find(y);
		if(x==y)return true;
		else return false;
	}
}