/*
 * 처음으로 Tokenizer 사용해봄. 이거 사용하는 습관 길러야지
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(sb.readLine()).nextToken());
        int[] balloons = new int[n];
        StringTokenizer st = new StringTokenizer(sb.readLine());
        for (int i = 0; i < n; i++)
            balloons[i] = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        answer.append(1).append(' ');
        int cur=0;
        int num=balloons[0];
        balloons[0]=0; // 터진 풍선
        for(int i=0;i<n-1;i++){
            if(num >= 0){
                for(int j=0;j<num;){
                    cur++;
                    cur %= n;
                    if (balloons[cur] != 0)
                        j++;
                }
            } else{
                for(int j=0;j<num*-1;){
                    cur--;
                    while(cur<0)
                        cur += n;
                    if (balloons[cur] != 0)
                        j++;
                }
            }
            num = balloons[cur];
            balloons[cur] = 0;
            answer.append(cur+1).append(' ');
        }
        System.out.print(answer);
    }
}