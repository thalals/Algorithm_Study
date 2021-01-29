#include <bits/stdc++.h>
using namespace std;

int graph[1001][1001];
int visited[1001][1001];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N, M;
struct node{
    int x, y;
};

void bfs(int x, int y) {
    queue<node> q;
    q.push({x, y});
    visited[x][y] = 0;

    while(!q.empty()) {
        node node = q.front(); q.pop();
        
        for(int i = 0; i < 4; i++) {
            int X = node.x + dx[i];
            int Y = node.y + dy[i];

            if(X < 0 || X == N || Y < 0 || Y == M) continue;
            if(visited[X][Y] != -1 || graph[X][Y]) continue;
            q.push({X, Y});
            visited[X][Y] = visited[node.x][node.y] + 1;
        }
    }
}

int main() {

    cin >> N >> M;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            scanf("%1d", &graph[i][j]);

    memset(visited, -1, sizeof(visited));
    int cnt = 0;


    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(graph[i][j] == 0 && visited[i][j] == -1) {
                bfs(i, j);
                cnt++;
            }
        }
    }
    cout << cnt << '\n';
}