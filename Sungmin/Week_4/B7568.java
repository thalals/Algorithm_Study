import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
/*처음에 등수를 기준으로 어떤 사람이 몇 등/같은 그룹인지 등수를 증가시키면서 구현하려 했었음
 *하지만 코드가 쓸데없이 길어지면서 본문에 나와있는 규칙 기준으로 다시 코드를 짬
 *'만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.'
 *등수 기준이 아니라 사람 기준으로 일일이 비교하면 쉽게 해결됐을 일. 문제 잘 읽을 걸.*/
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