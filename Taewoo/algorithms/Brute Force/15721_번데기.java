import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int A, T;
    static int ret;
    static void input() {
        A = scan.nextInt();
        T = scan.nextInt();
        ret = scan.nextInt();
    }

    static int turn;
    static int answer;
    static int cnt;
    static boolean flag;
    static void pro() {
        while(true) {
            turn++;
            ArrayList<Integer> data = new ArrayList<>(Arrays.asList(0, 1, 0, 1));
            for(int i = 0; i < turn + 1; i++) data.add(0);
            for(int i = 0; i < turn + 1; i++) data.add(1);
            for(int i = 0; i < data.size(); i++) {
                if(data.get(i) == ret) cnt++;
                if(cnt == T) {
                    flag = true;
                    sb.append(answer);
                    break;
                }
                answer++;
                answer %= A;
            }
            if(flag) break;
        }
        if(flag) System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
