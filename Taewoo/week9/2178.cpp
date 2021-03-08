/*
Problem: 미로 탐색 (2178)
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
Comment: 
*/

#include<bits/stdc++.h>
using namespace std;

int N, M;
int graph[101][101];
int visited[101][101];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;

int bfs(int x, int y) {
    q.push({x, y});
    visited[x][y] = 1;

    while(!q.empty()) {
        pair<int, int> p = q.front();
        q.pop();
        
        if(p.first == N && p.second == M) break;
        for(int i = 0; i < 4; i++) {
            int X = p.first + dx[i];
            int Y = p.second + dy[i];
            if(X < 1 || X > N || Y < 1 || Y > M || visited[X][Y]) continue;
            if(graph[X][Y] == 1) {
                visited[X][Y] = visited[p.first][p.second] + 1;
                q.push({X, Y});
            }
        }
    }
    return visited[N][M];
}

int main() {
    cin >> N >> M;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            scanf("%1d", &graph[i][j]);
        }
    }

    cout << bfs(1, 1);
}