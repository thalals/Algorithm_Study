#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Node {
    int num, x, y;
    Node(int num, int x, int y) : num(num), x(x), y(y) {}
    bool operator < (const Node &a) const&{
        return num < a.num;
    }
};

string s;
char map[25][25];
int start_x, start_y, end_x, end_y;
int dx[] = { -1, 1, 0, 0};
int dy[] = { 0, 0, -1, 1};
int N, M;
vector<vector<int> > dist;
vector<Node> numbering;
vector<pair<int, int> > pos;

int BFS(int s, int e) {
    queue<pair<int, int> > Q;
    vector<vector<int> > used(N, vector<int> (N));

    Q.push(pos[s]);
    used[pos[s].first][pos[s].second] = 1;
    int cnt = -1;

    while(!Q.empty()) {
        int qsize = Q.size();
        ++cnt;

        while(qsize--) {
            pair<int, int> cur = Q.front(); Q.pop();
            if(cur == pos[e]) return cnt;

            for(int k = 0; k < 4; k++) {
                int nx = cur.first + dx[k];
                int ny = cur.second + dy[k];
                if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
                if(map[nx][ny] != '.') continue;
                if(used[nx][ny]) continue;
                used[nx][ny] = 1;
                Q.push(make_pair(nx, ny));
            }
        }
    }
    return -1;
}

int answer = INT_MAX;
bool used[25];
void dfs(int cur, int cnt, int total) { // 0 0 0
    if(cnt >= 3) {
        if(dist[cur][M - 1] != -1)
            answer = min(answer, total + dist[cur][M - 1]);
        return;
    }
    for(int i = cur + 1; i < M - 1; i++) {
        if(used[i]) continue;
        used[i] = true;
        if(dist[cur][i] != -1) {
            dfs(i, cnt + 1, total + dist[cur][i]);
        }
        used[i] = false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> s;
        for(int j = 0; j < N; j++) {
            map[i][j] = s[j];
            if(s[j] == 'S') {
                start_x = i; start_y = j;
                map[i][j] = '.';
            }
            else if(s[j] == 'E') {
                end_x = i; end_y = j;
                map[i][j] = '.';
            }
            else if(isdigit(s[j])) {
                numbering.push_back(Node(s[j] - '0', i, j));
                map[i][j] = '.';
            }
        }
    }

    sort(numbering.begin(), numbering.end());

    pos.push_back(make_pair(start_x, start_y));
    for(int i = 0; i < numbering.size(); i++) {
        pos.push_back(make_pair(numbering[i].x, numbering[i].y));
    }
    pos.push_back(make_pair(end_x, end_y));
    M = pos.size();


    dist = vector<vector<int> > (M, vector<int>(M));
    for(int i = 0; i < M; i++) {
        for(int j = i; j < M; j++) {
            if(i == j) dist[i][j] = -1;
            else dist[i][j] = dist[j][i] = BFS(i, j);
        }
    }

    dfs(0, 0, 0);
    if(answer == INT_MAX) answer = -1;
    cout << answer;
}