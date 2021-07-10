#include<bits/stdc++.h>
using namespace std;

int graph[20][20];
void input() {
    for(int i = 1; i <= 19; i++)
        for(int j = 1; j <= 19; j++)
            cin >> graph[i][j];
}

int dx[] = {0, 1, 1, 1};
int dy[] = {1, 1, 0, -1};

bool OOB(int x, int y) {
    return x < 1 or x > 19 or y < 1 or y > 19;
}

void pro() {
    for(int i = 1; i <= 19; i++) {
        for(int j = 1; j <= 19; j++) {
            if(!graph[i][j]) continue;
            for(int dir = 0; dir < 4; dir++) {
                int x = i; int y = j;
                int count = 1;

                while(1) { // 방향별로 오목 확인
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!OOB(nx, ny) && graph[x][y] == graph[nx][ny]) {
                        // 같은 돌인지 확인하면서 계속 전진
                        count++;
                        x = nx; y = ny;
                        continue;
                    }

                    else if(count == 5) { // 6목 예외 처리
                        if(dir == 0 && graph[i][j] == graph[i][j - 1]) break;
                        if(dir == 1 && graph[i][j] == graph[i - 1][j - 1]) break;
                        if(dir == 2 && graph[i][j] == graph[i - 1][j]) break;
                        if(dir == 3 && graph[i][j] == graph[i - 1][j + 1]) break;
                        cout << graph[i][j] << '\n';
                        if(dir == 3) cout << x << ' ' << y << '\n';
                        else cout << i << ' ' << j << '\n';
                        return;
                    }
                    break;
                }
            }
        }
    }
    cout << 0 << '\n';
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
    return 0;
}