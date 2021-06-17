#include<bits/stdc++.h>
using namespace std;

struct Fish {
    int x, y, dir, live;
};

int answer = 0;
int _map[4][4];
int dx[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
Fish fish[17];

void input() {
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
            int a, b; cin >> a >> b;
            _map[i][j] = a;
            fish[a] = {i, j, b, 1};
        }
    }
}

void copy_map(int cmap[][4], int map[][4], Fish cfish[], Fish fish[]) {
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
            cmap[i][j] = map[i][j];
        }
    }

    for(int i = 1; i <= 16; i++){
        cfish[i] = fish[i];
    }
}

void move_fish() {
    for(int i = 1; i <= 16; i++) {
        /*
            1. 물고기가 죽어있으면 넘어가고
            2. 아니면 움직인다.
            3. 범위에 범어나거나 상어가 있으면 다른방향
            4. 빈칸이거나 다른 물고기가 있다면 움직일수있지만
            5. 다른 물고기가 있다면 둘이 위치 변경
        */
       if(fish[i].live == 0) continue;

       int x = fish[i].x;
       int y = fish[i].y;
       int dir = fish[i].dir;

       int nx = x + dx[dir];
       int ny = y + dy[dir];
       bool flag = false;

       // 움직이자
       if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
           
           if(_map[nx][ny] == 0) { // 빈칸인 경우
                flag = true;
                fish[i].x = nx;
                fish[i].y = ny;
                _map[nx][ny] = i;
                _map[x][y] = 0;       
           }
           else if(_map[nx][ny] != -1) { // 다른 물고기인경우
                flag = true;
                int idx = _map[nx][ny];
                Fish temp = fish[idx];
                fish[idx].x = fish[i].x;
                fish[idx].y = fish[i].y;
                fish[i].x = temp.x;
                fish[i].y = temp.y;

                swap(_map[nx][ny], _map[x][y]);
           }
       }

        // 움직이지 못하면 다른 방향
        if(flag == false) {
            int ddir = dir + 1;
            if(ddir == 9) ddir = 1;
            int nx = x + dx[ddir];
            int ny = y + dy[ddir];

            while(dir != ddir) {
                // 움직이자
                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                    if(_map[nx][ny] == 0) { // 빈칸인 경우
                        fish[i].x = nx;
                        fish[i].y = ny;
                        fish[i].dir = ddir;
                        _map[nx][ny] = i;
                        _map[x][y] = 0;
                        break;         
                    }
                    else if(_map[nx][ny] != -1) { // 다른 물고기인경우
                        int idx = _map[nx][ny];
                        Fish temp = fish[idx];
                        fish[idx].x = fish[i].x;
                        fish[idx].y = fish[i].y;
                        fish[i].x = temp.x;
                        fish[i].y = temp.y;
                        swap(_map[nx][ny], _map[x][y]);
                        fish[i].dir = ddir;
                        break;
                    }
                }
                ddir++;
                if(ddir == 9) ddir = 1;
                nx = x + dx[ddir];
                ny = y + dy[ddir];
            }
        }
    }
}

void dfs(int x, int y, int dir, int values) {

    answer = max(answer, values);
    // cout << "answer : " << answer << '\n';
    int cmap[4][4];
    Fish cfish[17];
    copy_map(cmap, _map, cfish, fish);

    // 물고기 이동
    move_fish();

    // 움직일수 있는 경우로 나눠서 상어 움직이기
    for(int i = 1; i <= 3; i++) {
        int nx = x + dx[dir] * i;
        int ny = y + dy[dir] * i;

        if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
            if(_map[nx][ny] == 0) continue;

            int fish_num = _map[nx][ny];
            fish[fish_num].live = 0;
            _map[nx][ny] = -1;
            _map[x][y] = 0;
            dfs(nx, ny, fish[fish_num].dir, values + fish_num);
            _map[nx][ny] = fish_num;
            _map[x][y] = -1;
            fish[fish_num].live = 1;
        }
        else break;
    }
    copy_map(_map, cmap, fish, cfish);
}

void pro() {
    int f = _map[0][0]; // 처음으로 먹는 물고기
    int dir = fish[f].dir; // 상어가 갈 방향
    fish[f].live = 0;
    _map[0][0] = -1; // 상어의 위치는 -1
    // 상어의 현좌표, 상어가 움직일 방향, 현재 최대 값
    dfs(0, 0, dir, f);

    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    input();
    pro();
    return 0;
}