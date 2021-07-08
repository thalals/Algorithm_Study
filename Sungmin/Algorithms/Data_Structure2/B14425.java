/*
 * 단순 구현 문제 솔직히 이거 못하면 벽보고 반성해야됨.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int x=Integer.parseInt(s[1]);
		s=new String[n];
		int count=0;
		for(int i=0;i<n;i++)
			s[i]=input.readLine();
		for(int i=0;i<x;i++) {
			String temp=input.readLine();
			for(int i1=0;i1<n;i1++) {
				if(temp.equals(s[i1])) {
					count++;
					break;
				}
			}
		}
		System.out.print(count);
		input.close();
	}
}
