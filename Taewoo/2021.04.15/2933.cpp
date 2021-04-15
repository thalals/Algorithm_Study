#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int R, C;
int N;
char graph[100][100];
int visit[100][100];
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
vector<int> stick;
vector<pair<int, int>> cluster;

void print() {
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            cout << graph[i][j];
        }
        cout << '\n';
    }
}

void input() {
    cin >> R >> C;
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            cin >> graph[i][j];
        }
    }
    cin >> N;
    for(int i = 0; i < N; i++) {
        int stick_num; cin >> stick_num;
        stick.push_back(stick_num);
    }
}

void throw_stick(int height, int flag) {
    height = R - height;
    if(flag == 1) {
        // Left
        for(int i = 0; i < C; i++) {
            if(graph[height][i] == 'x') {
                graph[height][i] = '.';
                break;
            }
        }
    }
    if(flag == 2) {
        // Right
        for(int i = C - 1; i >= 0; i--) {
            if(graph[height][i] == 'x') {
                graph[height][i] = '.';
                break;
            }
        }
    }
}

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    visit[x][y] = 1;
    q.push({x, y});

    while(!q.empty()) {
        pair<int, int> p = q.front(); q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = p.first + dx[i];
            int ny = p.second + dy[i];

            if(visit[nx][ny] || graph[nx][ny] == '.' || nx < 0 || ny < 0 || nx == R || ny == C)
                continue;
            
            visit[nx][ny] = true;
            q.push({nx, ny});
        }
    }
}

void find_cluster() {
    memset(visit, 0, sizeof(visit));
    for(int i = 0; i < C; i++) {
        if(graph[R - 1][i] == '.' || visit[R - 1][i]) continue;
        bfs(R - 1, i);
    }

    // 공중 미네랄 찾기
    cluster.clear();
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            if(!visit[i][j] && graph[i][j] == 'x') {
                graph[i][j] = '.';
                cluster.push_back({i, j});
            }
        }
    }
}

void fall_cluster() {
    if(cluster.size() == 0) return;
    bool down = true;
    while(down) {
        for(pair<int, int> p : cluster) {
            int nx = p.first + 1;
            int ny = p.second;
            // cout << nx << ' ' << ny << '\n';
            if(nx < 0 || ny < 0 || nx >= R || ny >= C || graph[nx][ny] == 'x') {
                down = false;
                break;
            }
        }

        if(down) {
            for(pair<int, int> &p : cluster) {
                p.first++;
            }
        }
    }

    for(pair<int, int> p: cluster) {
        graph[p.first][p.second] = 'x';
    }
}

void process() {
    for(int i = 0; i < stick.size(); i++) {
        if(i % 2 == 0) throw_stick(stick[i], 1);
        else throw_stick(stick[i], 2);
        find_cluster();
        fall_cluster();
    }
    print();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
    process();
}