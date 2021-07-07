/*
 * 기존 Deque의 사용방법만 안다면 쉽게 풀 수 있는 문제
 * 양 끝에서만 접근하기 때문에 ArrayList보다 LinkedList가 더 효율적일 것 이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
public class B10866 {
	public static void main(String[] args) throws IOException{
		Deque<String> array = new LinkedList<String>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int x=Integer.parseInt(input.readLine());
		for(int i=0;i<x;i++) {
			String[] s = input.readLine().split(" ");
			if(s[0].equals("push_back"))
				array.addLast(s[1]);
			else if(s[0].equals("push_front")) array.addFirst(s[1]);
			else if(s[0].equals("pop_front")) {
				if(array.size()==0)
					output.append("-1\n");
				else
					output.append(array.pollFirst()+"\n");
			}
			else if(s[0].equals("empty"))
				if(array.size()==0) output.append("1\n");
				else output.append("0\n");
			else if(s[0].equals("pop_back")) {
				if(array.size()==0) output.append("-1\n");
				else
					output.append(array.pollLast()+"\n");
			}
			else if(s[0].equals("size"))
				output.append(array.size()+"\n");
			else if(s[0].equals("front")) {
				if(array.size()==0) output.append("-1\n");
				else output.append(array.peekFirst()+"\n");
			}
			else if(s[0].equals("back")) {
				if(array.size()==0) output.append("-1\n");
				else output.append(array.peekLast()+"\n");
			}
		}
		System.out.print(output);
		input.close();
	}
}