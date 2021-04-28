#include<bits/stdc++.h>
using namespace std;

struct Fireball {
    int x, y, m, s, d;
};

int n, m, k;
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
vector<Fireball> board[51][51];
vector<Fireball> fireball;
void input() {
    cin >> n >> m >> k;
    for(int i = 0; i < m; i++) {
        int r,c,m,s,d;
        cin >> r >> c >> m >> s >> d;
        board[r][c].push_back({r, c, m, s, d});
        fireball.push_back({r, c, m, s, d});
    }
}

void move_fireball() {
    vector<Fireball> temp[51][51];
    for(int i = 0; i < fireball.size(); i++) {
        int x = fireball[i].x;
        int y = fireball[i].y;
        int mass = fireball[i].m;
        int speed = fireball[i].s;
        int dir = fireball[i].d;
        int nx = x, ny = y;
        for(int i = 0; i < speed; i++) {
            nx += dx[dir];
            ny += dy[dir];

            if(nx > n) nx = 1;
            if(nx < 1) nx = n;
            if(ny > n) ny = 1;
            if(ny < 1) ny = n;
        }
        fireball[i].x = nx;
        fireball[i].y = ny;
        temp[nx][ny].push_back({nx, ny, mass, speed, dir});
    }
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            board[i][j].clear();
            board[i][j] = temp[i][j];
        }
    }
}

void sum() {
    vector<Fireball> temp;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(board[i][j].size() == 0) continue;
            if(board[i][j].size() == 1) {
                temp.push_back(board[i][j][0]);
                continue;
            }

            int m_sum = 0, speed_sum = 0, cnt = board[i][j].size();
            bool even, odd;
            even = odd = true;
            for(int k = 0; k < cnt; k++) {
                m_sum += board[i][j][k].m;
                speed_sum += board[i][j][k].s;
                if(board[i][j][k].d % 2 == 0) {
                    // 짝수이면
                    odd = false;
                }
                else even = false;
            }
            int m = m_sum / 5;
            int s = speed_sum / cnt;
            if(m == 0) continue;
            if(odd == true || even == true) {
                for(int k = 0; k < 4; k++)
                    temp.push_back({i, j, m, s, k * 2});
            }
            else {
                for(int k = 0; k < 4; k++) {
                    temp.push_back({i, j, m, s, k * 2 + 1});
                }
            }
        }
    }
    fireball = temp;
}

void pro() {
    int answer = 0;
    for(int i = 0; i < k; i++) {
        move_fireball();
        sum();
    }


    for(int i = 0; i < fireball.size(); i++) {
        answer += fireball[i].m;
    }

    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}