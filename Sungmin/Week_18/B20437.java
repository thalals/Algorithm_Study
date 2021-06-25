import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class B20437 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<Integer> array[] = new ArrayList[26];
		for(int i=0;i<26;i++)
			array[i]=new ArrayList<Integer>();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			int[] result=new int[2];
			String s=input.readLine();
			for(int i1=0;i1<s.length();i1++)
				array[s.charAt(i1)-97].add(i1);
			int count=Integer.parseInt(input.readLine());
			if(count==1) sb.append("1 1\n");
			else {
				result=findString(array,count);
				if(result[0]==0&&result[1]==0)sb.append("-1\n");
				else sb.append(String.valueOf(result[0])+" "+String.valueOf(result[1])+"\n");
			}
			for(int i1=0;i1<26;i1++)
				array[i1].clear();
		}
		System.out.print(sb);
		input.close();
	}
	static int[] findString(ArrayList<Integer> array[], int count) {
		int[] result=new int[2];//0은 최소, 1은 최대
		for(int i=0;i<26;i++) {
			if(array[i].size()<count) continue;
			for(int i1=0;i1<=array[i].size()-count;i1++) {
				//right=i1+count-1
				if(result[0]==0)
					result[0]=array[i].get(i1+count-1)-array[i].get(i1)+1;
				else if(result[0]>array[i].get(i1+count-1)-array[i].get(i1)+1)
					result[0]=array[i].get(i1+count-1)-array[i].get(i1)+1;
				if(result[1]==0)
					result[1]=array[i].get(i1+count-1)-array[i].get(i1)+1;
				else if(result[1]<array[i].get(i1+count-1)-array[i].get(i1)+1)
					result[1]=array[i].get(i1+count-1)-array[i].get(i1)+1;
			}
		}
		return result;
	}
}