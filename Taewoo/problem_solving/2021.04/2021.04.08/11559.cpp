/*
Comment : 한번에 떨어뜨릴 수는 없을까?? 
*/
#include <bits/stdc++.h>
using namespace std;

char _map[12][6];
bool visited[12][6];
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
int cnt;
void input () {
    for(int i = 0; i < 12; i++) {
        string s; cin >> s;
        for(int j = 0; j < 6; j++) {
            _map[i][j] = s[j];
        }
    }
    // cout << "START" << '\n';
}

void dfs(int x, int y) {
    cnt++;
    visited[x][y] = true;

    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(nx < 0 || ny < 0 || nx == 12 || ny == 6) continue;
        if(_map[nx][ny] == '.') continue;
        if(visited[nx][ny] == true) continue;
        if(_map[x][y] != _map[nx][ny]) continue;
        dfs(nx, ny);
    }
}

void remove() {
    for(int i = 0; i < 12; i++) {
        for(int j = 0; j < 6; j++) {
            if(visited[i][j])
                _map[i][j] = '.';
        }
    }
}

void fall() {
    for(int j = 0; j < 6; j++) {
        while(1) {
            bool ok = false;
            for(int i = 11; i >= 1; i--) {
                if(_map[i][j] == '.' && _map[i - 1][j] != '.') {
                    _map[i][j] = _map[i - 1][j];
                    _map[i - 1][j] = '.';
                    ok = true;
                }
            }
            if(!ok) break;
        }
    }
}

void print() {
    for(int i = 0; i < 12; i++) {
        for(int j = 0; j < 6; j++) {
            cout << _map[i][j];
        }
        cout << '\n';
    }
}

void pro() {
    int answer = 0;
    while(1) {
        bool isOk = false;
        for(int i = 0 ; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                memset(visited, false, sizeof(visited));
                if(_map[i][j] != '.' && visited[i][j] == false) {
                    cnt = 0;
                    dfs(i, j);
                    if(cnt >= 4) {
                        isOk = true;
                        remove();
                        // cout << "remove" << '\n';
                        // print();
                    }
                }
            }
        }
        if(!isOk) break; // 4개를 더이상할게 없는 경우
        fall();
        // cout << "fall" << '\n';
        // print();
        answer++;
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
    return 0;
}