import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			String s=input.readLine();
			sb.append(String.valueOf(palindrome(s))+"\n");
		}
		System.out.print(sb);
		input.close();
	}
	static int palindrome(String s) {
		boolean flag=false;
		int right=s.length()-1;
		int left=0;
		while(true) {
			if(right<=left) {
				if(flag) return 1;
				else return 0;
			}
			if(s.charAt(left)!=s.charAt(right)) {
				if(!flag) {
					if(left+1==right) return 1;
					else if(s.charAt(left+1)==s.charAt(right)&&s.charAt(left)==s.charAt(right-1)) {
						if(s.charAt(left+1)==s.charAt(right-2))
							right-=1;
						else if(s.charAt(left+2)==s.charAt(right-1))
							left+=1;
						else return 2;
					}
					else if(s.charAt(left+1)==s.charAt(right))
						left+=1;
					else if(s.charAt(left)==s.charAt(right-1))
						right-=1;
					else return 2;
					flag=true;
				}
				else return 2;
			}
			left+=1;
			right-=1;
		}
	}
}