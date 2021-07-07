#include<bits/stdc++.h>
using namespace std;

struct node{
    int red_x;
    int red_y;
    int blue_x;
    int blue_y;
    int count;
};

int n, m, red_x, red_y, blue_x, blue_y, answer;
bool flag;
char board[11][11];
int visited[11][11][11][11];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
queue<node> q;

void input() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> board[i][j];
            if(board[i][j] == 'R') {
                red_x = i; red_y = j;
            }
            else if(board[i][j] == 'B') {
                blue_x = i; blue_y = j;
            }
        }
    }
}

void solution() {
    q.push({red_x, red_y, blue_x, blue_y, 0});
    visited[red_x][red_y][blue_x][blue_y] = 1;

    while(!q.empty()) {
        node current = q.front();
        q.pop();

        if(current.count > 10) break;
        if(board[current.red_x][current.red_y] == 'O') {
            flag = true;
            answer = current.count;
            break;
        }

        for(int i = 0; i < 4; i++) {
            // cout << "방향 : " << i << '\n';
            int next_red_x = current.red_x;
            int next_red_y = current.red_y;
            int next_blue_x = current.blue_x;
            int next_blue_y = current.blue_y;
            cout << i << " 방향 " << next_red_x << ' ' << next_red_y << ' ' << next_blue_x << ' ' << next_blue_y << '\n';
            while(1) {
                next_red_x += dx[i];
                next_red_y += dy[i];
                cout << "RED " << next_red_x << ' ' << next_red_y << '\n';
                if(board[next_red_x][next_red_y] == '#') {
                    next_red_x -= dx[i];
                    next_red_y -= dy[i];
                    break;
                    cout << "RED " << next_red_x << ' ' << next_red_y << '\n';
                }
                else if(board[next_red_x][next_red_y] == 'O')
                    break;
            }
            // cout << "빨간공 끝" << '\n';
            while(1) {
                next_blue_x += dx[i];
                next_blue_y += dy[i];
                cout << "BLUE " << next_blue_x << ' ' << next_blue_y << '\n';
                if(board[next_blue_x][next_blue_y] == '#') {
                    next_blue_x -= dx[i];
                    next_blue_y -= dy[i];
                    break;
                    cout << "BLUE " << next_blue_x << ' ' << next_blue_y << '\n';
                }
                else if(board[next_blue_x][next_blue_y] == 'O')
                    break;
            }
            // cout << "파랑공 끝" << '\n';
            // 파란 구슬이 빠지면?
            if(board[next_blue_x][next_blue_y] == 'O') continue;

            // 두 구슬이 겹치게되면?
            if(next_red_x == next_blue_x && next_red_y == next_blue_y) {
                // 오른쪽
                if(i == 0) current.red_y > current.blue_y ? next_blue_y-- : next_red_y--;
                // 왼쪽
                else if(i == 1) current.red_y > current.blue_y ? next_red_y++ : next_blue_y++;
                // 아래쪽
                else if(i == 2) current.red_x > current.blue_x ? next_blue_x-- : next_red_x--;
                // 위
                else if(i == 3) current.red_x > current.blue_x ? next_red_x++ : next_blue_x++;
                // cout << i << "!red! : " << next_red_x << ' ' << next_red_y << '\n';
                // cout << i << "!blue! : " << next_blue_x << ' ' << next_blue_y << '\n';
            }

            if(!visited[next_red_x][next_red_y][next_blue_x][next_blue_y]) {
                visited[next_red_x][next_red_y][next_blue_x][next_blue_y] = 1;
                q.push({next_red_x, next_red_y, next_blue_x, next_blue_y, current.count + 1});
            }
        }
    }
    if(flag) cout << answer;
    else cout << -1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solution();
}
// 3 1 1 3
// RED 3 2
// 3 1 1 3
// RED 3 0
// 3 1 1 3
// RED 4 1
// 3 1 1 3
// RED 2 1
// RED 1 1
// RED 0 1