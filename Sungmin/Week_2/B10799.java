import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
class StickLaser{
	char stickLaser;
	int stick;
}
public class B10799 {
	public static void main(String[] args) {
		try {
			int result=0;
			Stack<StickLaser> array = new Stack<StickLaser>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String s = input.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					StickLaser temp=new StickLaser();
					temp.stickLaser=s.charAt(i);
					temp.stick=1;
					array.push(temp);
				}
				else if(s.charAt(i)==')') {
					if(array.peek().stick==1) {
						array.pop();
						for(int i1=0;i1<array.size();i1++) {
							StickLaser temp1=array.get(i1);
							temp1.stick++;
							array.set(i1,temp1);
						}
					}
					else result+=array.pop().stick;
				}
			}
			while(array.size()!=0) result+=array.pop().stick;
			System.out.print(result);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}