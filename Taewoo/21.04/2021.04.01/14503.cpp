#include <bits/stdc++.h>
using namespace std;

int n, m, answer = 0;
int _map[51][51];
int rx, ry, dir;
int dx[] = {-1, 0, 1, 0}; // 북 동 남 서
int dy[] = {0, 1, 0, -1};
void input() {
    cin>> n >> m;
    cin >> rx >> ry >> dir;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> _map[i][j];
        }
    }
}

void clean() {
    /*
        1. 현재 위치를 청소하기
        2. 왼쪽방향부터 차례대로 진행
        3. 청소가 가능하면 -> 그방향으로 회전하고 전진하고 1번으로 이동
        4. 청소가 불가능하면, 계속해서 회전해서 확인
        5. 4방향이 다 안되면, 바라보는 방향을 유지한채 후진후 2번
        6. 뒤로도 못가면, 작동 금지
    */
    while(1) {
        // 1. 현재 위치 청소하기
        if(_map[rx][ry] == 0) {
            _map[rx][ry] = 2;
            answer++;
        }

        // 왼쪽방향으로 진행
        bool flag = true;
        int nx, ny, nd;
        for(int i = 0; i < 4; i++) {
            nd = (dir + 3) % 4;
            nx = rx + dx[nd];
            ny = ry + dy[nd];

            // 범위에 벗어났다면...
            if(nx < 0|| ny < 0 || nx == n || ny == m) {
                dir = nd;
                continue;
            }
            // 벽이거나, 청소했던 곳이면
            if(_map[nx][ny] == 1 || _map[nx][ny] == 2) {
                dir = nd;
                continue;
            }
            //청소가 가능하면
            if(_map[nx][ny] == 0) {
                flag = false;
                dir = nd;
                rx = nx, ry = ny;
                break;
            }
        }
        // 5. 4방향이 다 안되면??
        if(flag) {
            // 바라보는 방향을 유지한채 후진후 왼쪽방향 다시 확인
            nx = rx + dx[(dir + 2) % 4];
            ny = ry + dy[(dir + 2) % 4];
            if(nx < 0 || ny < 0 || nx == n || ny == m) {
                break;
            } 
            if(_map[nx][ny] == 1) {
                break;
            }
            rx = nx, ry = ny;
        }
    }
}
void pro() {
    clean();
    cout << answer;
}
int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
    return 0;
}