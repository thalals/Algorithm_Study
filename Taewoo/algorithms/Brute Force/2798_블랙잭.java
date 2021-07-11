import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] arr =  new int[100];
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static int answer;
    static void pro() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                for(int k = 0; k < j; k++) {
                    if(arr[i] + arr[j] + arr[k] <= M) {
                        answer = Math.max(answer, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        sb.append(answer);
        System.out.println(sb.toString());
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
