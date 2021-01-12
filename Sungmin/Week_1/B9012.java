import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
public class B9012 {
	public static void main(String[] args) {
		try {
			List<Character> array = new ArrayList<Character>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				array.removeAll(array);
				String s = input.readLine();
				for(int i1=0;i1<s.length();i1++) {
					if(s.charAt(i1)=='(')//push
						array.add(s.charAt(i1));
					else if(s.charAt(i1)==')') {//pop
						if(array.size()==0) {
							output.write("NO\n");
							break;
						}
						else array.remove(array.size()-1);
					}
					if(i1==s.length()-1) {
						if(array.size()==0)output.write("YES\n");
						else output.write("NO\n");
					}
				}
			}
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}