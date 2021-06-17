#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;
struct Node {
    int x, y, time;
};

int graph[350][350];
int n, m, k, answer;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int TC;
    cin >> TC;

    for(int tc = 1; tc <= TC; tc++) {
        memset(graph, 0, sizeof(graph));
        answer = 0;
        cin >> n >> m >> k;

        queue<Node> q[11];

        for(int i = 150; i < n + 150; i++) {
            for(int j = 150; j < m + 150; j++) {
                cin >> graph[i][j];
                if(graph[i][j])
                    q[graph[i][j]].push({i, j, 2 * graph[i][j]});
            }
        }

        while(k--) {
            for(int i = 10; i >= 1; i--) {
                int size = (int) q[i].size();

                for(int j = 0; j < size; j++) {
                    int x = q[i].front().x;
                    int y = q[i].front().y;
                    int time = q[i].front().time;
                    q[i].pop();
                
                    time--;

                    if(graph[x][y] > time) {
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(graph[nx][ny] == 0) {
                                graph[nx][ny] = graph[x][y];
                                q[i].push({nx, ny, graph[nx][ny] * 2});
                            }
                        }
                    }

                    if(time > 0) {
                        q[i].push({x, y, time});
                    }
                }
            }
        }
        
        for(int i = 1; i < 11; i++)
            answer += q[i].size();
    
        cout << "#" << tc << " " << answer << '\n';
    }

    return 0;
}