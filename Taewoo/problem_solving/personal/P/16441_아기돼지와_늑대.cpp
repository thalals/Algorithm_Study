#include<bits/stdc++.h>
using namespace std;

int n, m;
char board[101][101];
int visit[101][101];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

void input() {
    string s;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> s;
        for(int j = 0; j < m; j++) {
            board[i][j] = s[j];
        }
    }
}

void dfs(int x, int y) {
    visit[x][y] = 1;
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || ny < 0 || nx == n || ny == m || visit[nx][ny]) continue;
        if(board[nx][ny] == '#') continue;
        if(board[nx][ny] == '.' || board[nx][ny] == 'W') {
            // 초원일 때
            dfs(nx, ny);
        }
        else {
            // 빙판 일떄
            while((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && board[nx][ny] == '+') {
                nx += dx[i];
                ny += dy[i];
            }
            if(board[nx][ny] == '#') {
                nx -= dx[i];
                ny -= dy[i];
            }
            if(visit[nx][ny] == 0){
                dfs(nx, ny);
            }
        }
    }
}

void pro() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(board[i][j] == 'W')
                dfs(i, j);
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(visit[i][j] == false && board[i][j] == '.') {
                cout << "P";
            }
            else {
                cout << board[i][j];
            }
        }
        cout << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    input();
    pro();
    return 0;
}