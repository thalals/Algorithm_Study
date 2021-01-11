import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
public class B10828 {
	public static void main(String[] args) {
		try {
			List<String> array = new ArrayList<String>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				String[] s = input.readLine().split(" ");
				if(s[0].equals("push"))
					array.add(s[1]);
				else if(s[0].equals("pop")) {
					if(array.size()==0) output.write("-1\n");
					else {
						output.write(array.get(array.size()-1)+"\n");
						array.remove(array.size()-1);
					}
				}
				else if(s[0].equals("empty"))
					if(array.size()==0) output.write("1\n");
					else output.write("0\n");
				else if(s[0].equals("top"))
					if(array.size()==0) output.write("-1\n");
					else output.write(array.get(array.size()-1)+"\n");
				else if(s[0].equals("size"))
					output.write(array.size()+"\n");
			}
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}