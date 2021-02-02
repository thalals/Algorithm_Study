import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class B7568 {
	static class Dungchi{
		int weight;
		int height;
		int priority;
		Dungchi(int weight, int height){
			this.weight=weight;
			this.height=height;
			this.priority=1;
		}
	}
	public static void main(String[] args) {
		try {
			ArrayList<Dungchi> array = new ArrayList<Dungchi>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			int x = Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {//
				String[] s = input.readLine().split(" ");
				array.add(new Dungchi(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
			}
			for(int i=0;i<x;i++) {
				for(int i1=0;i1<x;i1++) {
					if(i1==i) continue;
					if((array.get(i).height<array.get(i1).height)&&(array.get(i).weight<array.get(i1).weight))
						array.get(i).priority++;
				}
			}
			for(int i=0;i<array.size();i++) output.write(String.valueOf(array.get(i).priority)+" ");
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}