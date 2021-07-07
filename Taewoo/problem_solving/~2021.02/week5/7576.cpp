#include<iostream>
#include<queue>
#include<vector>
using namespace std;

struct node{
    int x;
    int y;
};

int N, M;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
vector<int> graph[1001];
queue<node> q;

void bfs() {
    while(!q.empty()) {
        node node = q.front();
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nextX = dx[i] + node.x;
            int nextY = dy[i] + node.y;
            if(nextX < 0 || nextX == N || nextY < 0 || nextY == M) continue;
            if(graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = graph[node.x][node.y] + 1;
                q.push({nextX, nextY});
            }
        }
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> M >> N;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            int num; cin >> num;
            graph[i].push_back(num);
            if(graph[i][j] == 1) q.push({i, j});
        }
    }

    bfs();
    int answer = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(!graph[i][j]) {
                cout << -1 << '\n';
                return 0;
            }
            answer = max(answer, graph[i][j]);
        }
    }
    cout << answer - 1;
}