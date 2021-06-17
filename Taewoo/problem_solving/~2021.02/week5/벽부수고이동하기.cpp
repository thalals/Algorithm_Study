#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int graph[1001][1001];
int visited[1001][1001][2];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, -1, 1};
int N, M;

struct node {
    int x, y;
    int isCracked;
};

int main() {

    cin >> N >> M;
    for(int i = 0; i < N; i++) 
        for(int j = 0; j < M; j++)
            scanf("%1d", &graph[i][j]);
    
    queue<node> q;
    memset(visited, -1, sizeof(visited));
    visited[0][0][0] = 1;
    q.push({0, 0, 0});

    while(!q.empty()) {
        node n = q.front(); q.pop();
        for(int i = 0; i < 4; i++) {
            int X = n.x + dx[i], Y = n.y + dy[i];
            if(X < 0 || X == N || Y < 0 || Y == M) continue;

            if(graph[X][Y] == 1) {
                if(!n.isCracked) {
                    if(visited[X][Y][1] != -1) continue;
                    visited[X][Y][1] = visited[n.x][n.y][0] + 1;
                    q.push({X, Y, 1});
                } else {
                    continue;
                }
            }

            else {
                if(visited[X][Y][n.isCracked] != -1) continue;
                visited[X][Y][n.isCracked] = visited[n.x][n.y][n.isCracked] + 1;
                q.push({X, Y, n.isCracked});
            }
        }
    }

    cout << endl;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cout << visited[i][j][0] << ' ';
        }
        cout << '\n';
    }
    cout << endl;

    cout << endl;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cout << visited[i][j][1] << ' ';
        }
        cout << '\n';
    }
    cout << endl;
    int MIN = min(visited[N - 1][M - 1][0],visited[N - 1][M - 1][1]);
    int MAX = max(visited[N - 1][M - 1][0],visited[N - 1][M - 1][1]);
    
    if(MAX == -1) cout << "-1";
    else if(MIN == -1) cout << MAX;
    else cout << MIN;
}