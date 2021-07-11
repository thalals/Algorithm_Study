import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[][] graph = new int[11][11];
    static int[][] visited = new int[11][11];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 987654321;
    static void input() {
        N = scan.nextInt();
        for(int i = 0; i < N; i++) {
            String str;
            str = scan.nextLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }
    }

    // 꽃을 심을 수 있는가?
    static boolean isOk(int x, int y) {
        if(visited[x][y] != 0) return false;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx == N || ny == N) return false;
            if(visited[nx][ny] != 0) return false;
        }
        return true;
    }

    // 비용 구하기, 꽃 심기
    static int cost(int x, int y) {
        int sum = graph[x][y];
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            sum += graph[nx][ny];
            visited[nx][ny] = 1;
        }
        return sum;
    }

    // 복원하기
    static void back(int x, int y) {
        visited[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = 0;
        }
        return;
    }

    // 꽃 3개 심기
    static void go(int sum, int flower) {
        if(flower == 3) {
            answer = Math.min(sum, answer);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isOk(i, j)) { // 꽃이 필수 있나?
                    int value = cost(i, j);
                    go(sum + value, flower + 1);
                    back(i, j);
                }
            }
        }
    }

    static void pro() {
        go(0, 0);
        System.out.println(answer);
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
