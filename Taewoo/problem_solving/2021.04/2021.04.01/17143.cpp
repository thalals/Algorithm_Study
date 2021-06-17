/*
Comment : 상어는 한칸이 움직이니 시간초과발생
          최대의 상어수 10000 마리, 10000마리가 1000의 스피드,
          즉, 1000칸씩 움직이게 될 경우
          10000 * 1000 = 10^7의 시간이 걸리며, 1~C열까지 움직여야 하니
          10^7 * 10^2(C의 최대값)
          한번에 구할 수 있는 방법이 존재하네요.....
*/
#include<bits/stdc++.h>
using namespace std;

struct SHARK {
    int x, y;
    int speed;
    int dir;
    int size;
    int num;
};

vector<int> _map[101][101];
vector<SHARK> shark;
int R, C, answer, m;
int x, y;
int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, 1, -1};

// 입력 받기
void input() {
    cin >> R >> C >> m;
    for(int i = 0; i < m; i++) {
        int r, c, s, d, z; // 위치, 속력, 방향, 크기
        cin >> r >> c >> s >> d >> z;
        shark.push_back({r, c, s, d, z, i});
        _map[r][c].push_back(i);
    }
};

void fish(int c) {
    for(int i = 1; i <= R; i++) {
        // 격자판에 상어가 있다면. 잡자.
        if(_map[i][c].size() != 0) {
            answer += shark[_map[i][c][0]].size; // 상어 크기 더해주기
            shark[_map[i][c][0]].size = 0;
            _map[i][c].clear(); // 상어 삭제
            break;
        }
    }
}

void move_shark() {
    for(int i = 0; i < shark.size(); i++) {
        if(shark[i].size == 0) continue;
        int x = shark[i].x;
        int y = shark[i].y;
        _map[x][y].clear();
    }

    for(int i = 0; i< shark.size(); i++) {
        if(shark[i].size == 0) continue;
        int x = shark[i].x;
        int y = shark[i].y;
        int dir = shark[i].dir;
        int speed = shark[i].speed;
        
        if(dir == 1 || dir == 2) {
            int rot = (R - 1) * 2;
            if(speed >= rot) speed = speed % rot;
        }
        else {
            int rot = (C - 1) * 2;
            if(speed >= rot) speed = speed % rot;
        }

        for(int j = 0; j < speed; j++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 1) {
                dir = 2;
                nx = nx + 2;
            }
            if(nx > R) {
                dir = 1;
                nx = nx - 2;
            }
            if(ny < 1) {
                dir = 3;
                ny = ny + 2;
            }
            if(ny > C) {
                dir = 4;
                ny = ny - 2;
            }
            x = nx, y = ny;
        }
        shark[i].x = x;
        shark[i].y = y;
        shark[i].dir = dir;
        _map[x][y].push_back(i);
    }
};

bool compare(const int &a, const int &b) {
    if(shark[a].size > shark[b].size) {
        return true;
    }
    else {
        return false;
    }
}

void kill_shark() {
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            if(_map[i][j].size() >= 2) {
                sort(_map[i][j].begin(), _map[i][j].end(), compare);
                int win_shark = _map[i][j][0];
                for(int k = 1; k < _map[i][j].size(); k++) {
                    shark[_map[i][j][k]].size = 0;
                }
                _map[i][j].clear();
                _map[i][j].push_back(shark[win_shark].num);
            }
        }
    }
};
void pro() {
    // 낚시하기
    for(int i = 1; i <= C; i++) {
        fish(i);
        move_shark();
        kill_shark();
    }
    cout << answer;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
    return 0;
}