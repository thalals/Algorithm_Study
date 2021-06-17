#include<bits/stdc++.h>
using namespace std;

struct SHARK {
    int x, y;
    int speed;
    int dir;
    int size;
    int num;
    SHARK(int x, int y, int speed, int dir, int size, int num) : x(x), y(y), speed(speed), dir(dir), size(size), num(num) {};
};

vector<int> map[101][101];
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
        shark.push_back(SHARK(r, c, s, d, z, i));
        map[r][c].push_back(i);
    }
};

void fish(int c) {
    for(int i = 1; i <= R; i++) {
        // 격자판에 상어가 있다면. 잡자.
        if(map[i][c].size() != 0) {
            answer += shark[map[i][c][0]].size; // 상어 크기 더해주기
            shark[map[i][c][0]].size = 0;
            map[i][c].clear(); // 상어 삭제
            break;
        }
    }
}

void move_shark() {
    for(int i = 0; i < shark.size(); i++) {
        if(shark[i].size == 0) continue;
        int x = shark[i].x;
        int y = shark[i].y;
        map[x][y].clear();
    }

    // 상1 하2 좌3 우4
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
        map[x][y].push_back(i);
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
            if(map[i][j].size() >= 2) {
                sort(map[i][j].begin(), map[i][j].end(), compare);
                int win_shark = map[i][j][0];
                for(int k = 1; k < map[i][j].size(); k++) {
                    shark[map[i][j][k]].size = 0;
                }
                map[i][j].clear();
                map[i][j].push_back(shark[win_shark].num);
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