#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
int TC;
int N, X, dir, answer;
int visit[20][20];
int graph[20][20];
int dx[] = {0, 1};
int dy[] = {1, 0};

void dfs(int x, int y, int pre_value) {
    if(x == N || y == N) {
        answer++;
        return;
    }

    int nx = x + dx[dir];
    int ny = y + dy[dir];

    // 2 2
    if(graph[x][y] == pre_value) {
        dfs(nx, ny, graph[x][y]);
    }

    // 2 3
    else if(graph[x][y] == pre_value + 1) {
        int pivot = graph[x][y];
        for(int i = 0; i < X; i++) {
            x -= dx[dir];
            y -= dy[dir];
            if(graph[x][y] + 1 != pivot || visit[x][y] == 1 || x < 0 || y < 0 || x == N || y == N)
                return;
            visit[x][y] = 1;
        }
        dfs(nx, ny, pre_value + 1);
    }

    // 3 2
    else if(graph[x][y] == pre_value - 1) {
        int pivot = pre_value;
        for(int i = 0; i < X; i++) {
            if(graph[x][y] + 1 != pivot || visit[x][y] == 1 || x < 0 || y < 0 || x == N || y == N)
                return;
            visit[x][y] = 1;
            x += dx[dir];
            y += dy[dir];
        }
        dfs(x, y, pre_value - 1);
    }
}

void process(int testcase) {
    answer = 0;

    dir = 0;
    for(int i = 0; i < N; i++) {
        memset(visit, 0, sizeof(visit));
        dfs(i, 0, graph[i][0]);
    }

    dir = 1;
    for(int i = 0; i < N; i++) {
        memset(visit, 0, sizeof(visit));
        dfs(0, i, graph[0][i]);
    }
    cout << "#" << testcase << " " << answer << '\n';
}

void input() {
    cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        memset(graph, 0, sizeof(graph));
        cin >> N >> X;
        for(int i = 0; i < N; i++)
            for(int j =0; j < N; j++)
                cin >> graph[i][j];
        
        process(tc);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
    return 0;
}