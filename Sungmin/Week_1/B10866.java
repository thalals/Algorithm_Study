import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class B10866 {
	public static void main(String[] args) {
		try {
			List<String> array = new ArrayList<String>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder output = new StringBuilder();
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				String[] s = input.readLine().split(" ");
				if(s[0].equals("push_back"))
					array.add(s[1]);
				else if(s[0].equals("push_front")) array.add(0, s[1]);
				else if(s[0].equals("pop_front")) {
					if(array.size()==0) output.append("-1\n");
					else {
						output.append(array.get(0)+"\n");
						array.remove(0);
					}
				}
				else if(s[0].equals("empty"))
					if(array.size()==0) output.append("1\n");
					else output.append("0\n");
				else if(s[0].equals("pop_back")) {
					if(array.size()==0) output.append("-1\n");
					else {
						output.append(array.get(array.size()-1)+"\n");
						array.remove(array.size()-1);
					}
				}
				else if(s[0].equals("size"))
					output.append(array.size()+"\n");
				else if(s[0].equals("front")) {
					if(array.size()==0) output.append("-1\n");
					else output.append(array.get(0)+"\n");
				}
				else if(s[0].equals("back")) {
					if(array.size()==0) output.append("-1\n");
					else output.append(array.get(array.size()-1)+"\n");
				}
			}
			System.out.print(output);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}