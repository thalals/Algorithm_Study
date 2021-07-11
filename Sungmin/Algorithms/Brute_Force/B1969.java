/*
 * 문제 2번 잘못 읽어서 시간 개오래걸림
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(stk.nextToken());
		int m=Integer.parseInt(stk.nextToken());
		String[] dnas=new String[n];
		char[] result=new char[m];
		for(int i=0;i<n;i++)
			dnas[i]=input.readLine();
		int count=0;
		for(int i=0;i<m;i++) {
			int[] acgt=new int[4];
			for(int i1=0;i1<n;i1++) {
				if(dnas[i1].charAt(i)=='A')
					acgt[0]++;
				else if(dnas[i1].charAt(i)=='C')
					acgt[1]++;
				else if(dnas[i1].charAt(i)=='G')
					acgt[2]++;
				else acgt[3]++;
			}
			int temp=findMax(acgt);
			if(temp==0) result[i]='A';
			else if(temp==1) result[i]='C';
			else if(temp==2) result[i]='G';
			else if(temp==3)result[i]='T';
			count+=(n-acgt[temp]);
		}
		for(int i=0;i<m;i++)
			sb.append(result[i]);
		sb.append("\n"+count);
		System.out.print(sb);
		input.close();
	}
	static int findMax(int[] obj) {
		int index=0;
		for(int i=1;i<obj.length;i++) {
			if(obj[index]<obj[i])
				index=i;
		}
		return index;
	}
}