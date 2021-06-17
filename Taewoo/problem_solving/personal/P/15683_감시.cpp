#include<bits/stdc++.h>
using namespace std;
struct CCTV {
    int type, y, x;
};

int n, m, ret;
int board[8][8];
int cctv_size;
CCTV cctv[8];


void input() {
    cin >> n >> m;
    for(int y = 0; y < n; y++) {
        for(int x = 0; x < m; x++) {
            cin >> board[y][x];
            if(board[y][x] != 0 && board[y][x] != 6){
                cctv[cctv_size].y = y;
                cctv[cctv_size].x = x;
                cctv[cctv_size].type = board[y][x] - 1;
                cctv_size++;
            }
        }
    }
}


void map_copy(int desc[8][8], int src[8][8]) {
    for(int y = 0; y < n; y++) {
        for(int x = 0; x < m; x++) {
            desc[y][x] = src[y][x];
        }
    }
}

void update(int dir, CCTV cctv) {
    dir = (dir % 4);

    if(dir == 0) {
        for(int x = cctv.x + 1; x < m; x++) {
            if(board[cctv.y][x] == 6) break;
            board[cctv.y][x] = -1; // -1은 감시가 되었다는 의미
        }
    }
    if(dir == 1) {
        for(int y = cctv.y - 1; y >= 0; y--) {
            if(board[y][cctv.x] == 6) break;
            board[y][cctv.x] = -1; // -1은 감시가 되었다는 의미
        }
    }
    if(dir == 2) {
        for(int x = cctv.x - 1; x >= 0; x--) {
            if(board[cctv.y][x] == 6) break;
            board[cctv.y][x] = -1; // -1은 감시가 되었다는 의미
        }
    }
    if(dir == 3) {
        for(int y = cctv.y + 1; y < n; y++) {
            if(board[y][cctv.x] == 6) break;
            board[y][cctv.x] = -1; // -1은 감시가 되었다는 의미
        }
    }
}

const int rot_size[] = {4, 2, 4, 4, 1};
void dfs(int idx) {
    if(idx == cctv_size) {
        int candid = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[y][x] == 0) {
                    candid++;
                }
            }
        }
        ret = min(ret, candid);
        return;
    }

    int backup[8][8];
    int type = cctv[idx].type;
    for(int dir = 0; dir < rot_size[type]; dir++) {
        // 맵을 백업하고
        map_copy(backup, board);
        // 맵 업데이트

        if(type == 0) {
            update(dir, cctv[idx]);
        }
        else if(type == 1){
            update(dir, cctv[idx]);
            update(dir + 2, cctv[idx]);
        }
        else if(type == 2) {
            update(dir, cctv[idx]);
            update(dir +1, cctv[idx]);
        }
        else if(type == 4){
            update(dir, cctv[idx]);
            update(dir + 1, cctv[idx]);
            update(dir + 2, cctv[idx]);
            update(dir + 3, cctv[idx]);
        }

        dfs(idx + 1);
        map_copy(board, backup);
        // 맵을 복구하고
    }
}

void pro() {
    ret = 100;
    dfs(0);
    cout << ret;
}

int main() {
    input();
    pro();
    return 0;
}