#include<bits/stdc++.h>
using namespace std;
int N, M;
int graph[201][201];
int visited[201][201];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = 1;
    bool flag = false;

    while(!q.empty()) {
        pair<int, int> p = q.front(); q.pop();

        for(int i = 0; i < 4; i++) {
            int X = p.first + dx[i];
            int Y = p.second + dy[i];
            
            if(X < 0 || X == N || Y < 0 || Y == M) continue;
            if(!graph[X][Y] || visited[X][Y]) continue;
            q.push({X, Y});
            visited[X][Y] = visited[p.first][p.second] + 1;
            if(X == N - 1 && Y == M - 1) {
                flag = true;
                break;
            }
        }
        if(flag) break;
    }
}

int main() {
    cin >> N >> M;

    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            scanf("%1d", &graph[i][j]);

    memset(visited, 0, sizeof(visited));

    bfs(0, 0);

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cout << visited[i][j] << ' ';
        }cout << '\n';
    }

    cout << visited[N-1][M-1] << '\n';
}