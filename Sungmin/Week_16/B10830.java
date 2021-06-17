import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B10830 {
	static StringBuilder sb=new StringBuilder();
	static String[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<int[][]> table=new ArrayList<>();
		String[] s =input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		long b=Long.parseLong(s[1]);
		String binary=toBinary(b);
		int[][] array=new int[n][n];
		int[][] result=new int[n][n];
		boolean firstFlag=false;
		for(int i=0;i<n;i++) {
			s=input.readLine().split(" ");
			for(int i1=0;i1<n;i1++)
				array[i][i1]=Integer.parseInt(s[i1]);
		}
		makingTable(table, array, n);
		for(int i=0;i<binary.length();i++) {
			if(binary.charAt(i)=='1') {
				if(!firstFlag) {
					firstFlag=true;
					result=table.get(i);
				}
				else {
					result=arrayMul(result,table.get(i),n);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int i1=0;i1<n;i1++)
				sb.append(result[i][i1]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
		input.close();
	}
	
	static String toBinary(long num) {
		StringBuilder result=new StringBuilder();
		while(num!=0) {
			if(num%2==0)
				result.append("0");
			else
				result.append("1");
			num/=2;
		}
		return result.toString();
	}
	
	static int[][] arrayMul(int[][] array1,int[][] array2, int n){
		int[][] result=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int i1=0;i1<n;i1++) {
				for(int i2=0;i2<n;i2++)
					result[i][i1]=(result[i][i1]+array1[i][i2]*array2[i2][i1])%1000;
			}
		}
		return result;
	}
	
	static void makingTable(ArrayList<int[][]> table, int[][] array, int n) {
		int[][] firstarray=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int i1=0;i1<n;i1++)
				firstarray[i][i1]=array[i][i1]%1000;
		}
		table.add(firstarray);
		int[][] temp=array;
		for(int i=1;i<37;i++) {
			temp=arrayMul(temp,temp,n);
			table.add(temp);
		}
	}
}