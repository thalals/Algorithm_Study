#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <queue>
using namespace std;

int n, m, r, c, l;
int graph[50][50];
int visit[50][50];
int check[8][4] = {
    {0, 0, 0, 0},
    {1, 1, 1, 1},
    {1, 1, 0, 0},
    {0, 0, 1, 1},
    {1, 0, 1, 0},
    {0, 1, 1, 0},
    {0, 1, 0, 1},
    {1, 0, 0, 1}
}; // ╩С го ©Л аб
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, 1, -1};
int answer;
int reverse_dir;

void input() {
    cin >> n >> m >> r >> c >> l;
    for(int i = 0; i < n; i++) for(int j = 0; j < m; j++) cin >> graph[i][j];
}

void dfs(int x, int y, int cnt) {
    if(cnt == l) return;

    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(i == 0) reverse_dir = 1;
        else if(i == 1) reverse_dir = 0;
        else if(i == 2) reverse_dir = 3;
        else if(i == 3) reverse_dir = 2;

        if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if(check[graph[x][y]][i] == 1 && check[graph[nx][ny]][reverse_dir] == 1) {
                if(!visit[nx][ny] || visit[nx][ny] > visit[x][y] + 1) {
                    visit[nx][ny] = cnt + 1;
                    dfs(nx, ny, cnt + 1);
                }
            }
        }
    }
}

void pro() {
    visit[r][c] = 1;
    dfs(r, c, 1);

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(visit[i][j]) answer++;
        }
    }
}

void process() {
    int TC; cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        answer = 0;
        memset(visit, 0, sizeof(visit));
        input();
        pro();

        cout << "#" << tc << " " << answer << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    process();
    return 0;
}