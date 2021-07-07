import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742 {
	static StringBuilder sb=new StringBuilder();
	static String[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String temp="";
		String[] s;
		while((temp=input.readLine())!=null) {
			s=temp.split(" ");
			int maxsize=1;
			int num=Integer.parseInt(s[1]);
			for(int i=s[0].length();i>1;i--)
				maxsize*=i;
			result=new String[s[0].length()];
			if(maxsize<num)
					sb.append(s[0]+" "+s[1]+" = "+"No permutation"+"\n");
			else {
				result=s[0].split("");
				for(int i=1;i<num;i++)
					result=permutation(result);
				sb.append(s[0]+" "+s[1]+" = ");
				print(result);
			}
		}
		System.out.print(sb);
		input.close();
	}
	
	static String[] permutation(String[] obj) {
		String[] copies=new String[obj.length];
		for(int i=0;i<obj.length;i++)
			copies[i]=obj[i];
		int index=-1;
		for(int i=0;i<copies.length-1;i++) {
			if(copies[i].charAt(0)<copies[i+1].charAt(0)) index=i;
		}
		if(index<0) return null;
		for(int i=copies.length-1;i>index;i--) {
			if(copies[index].charAt(0)<copies[i].charAt(0)) {
				String temp=copies[index];
				copies[index]=copies[i];
				copies[i]=temp;
				break;
			}
		}
		int leftindex=index+1;
		int rightindex=copies.length-1;
		while(true) {
			if(leftindex>=rightindex) break;
			String temp=copies[leftindex];
			copies[leftindex++]=copies[rightindex];
			copies[rightindex--]=temp;
		}
		return copies;
	}
	
	static void print(String[] obj) {
		for(int i=0;i<obj.length;i++)
			sb.append(obj[i]);
		sb.append("\n");
	}
}