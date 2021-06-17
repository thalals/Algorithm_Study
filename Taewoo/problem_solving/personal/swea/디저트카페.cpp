#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;


int answer, n;
int graph[20][20];
int visit[20][20];
int st_x, st_y;
int value[101];
int depth_cnt[4];
int dx[] = {1, 1, -1, -1};
int dy[] = {-1, 1, 1, -1};

bool check() {
    for(int i = 0; i < 4; i++) {
        if(!depth_cnt[i]) return false;
    }
    return true;
}

void dfs(int x, int y, int dir, int dept) {

    if(x == -1 || x == n || y == -1 || y == n) return;
    if(visit[x][y] == 1) {
        if(check() && x == st_x && y == st_y) {
            answer = max(answer, dept - 1);
        }
        return;
    }

    if(value[graph[x][y]] == 1)
        return;

    value[graph[x][y]] = 1;
    visit[x][y] = 1;
    for(int i = dir; i < 4; i++) {
        depth_cnt[i]++;
        int nx = x + dx[i];
        int ny = y + dy[i];
        dfs(nx, ny, i, dept + 1);
        depth_cnt[i]--;
    }
    value[graph[x][y]] = 0;
    visit[x][y] = 0;
}

int main() {
    int TC; cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        answer = -1;

        memset(graph, 0, sizeof(graph));
        memset(visit, 0, sizeof(visit));
        
        cin >> n;
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) cin >> graph[i][j];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                st_x = i; st_y = j;
                dfs(i, j, 0, 1);
            }
        }
        cout << "#" << tc << ' ' << answer << '\n';
    }
}