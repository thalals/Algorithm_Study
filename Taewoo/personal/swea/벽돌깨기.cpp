#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int T, N, W, H, ret;
int graph[15][12];
int temp[15][12];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
/*
    1. 어느 열에 구슬을 던질까??
    2. 모든 구슬을 다 던지면??
    3. 남은 벽돌의 개수를 찾아라
*/

void boom(int x, int y) {
    if(!graph[x][y]) return;
    int k = graph[x][y];
    graph[x][y] = 0;

    for(int i = 0; i < k; i++) {
        for(int j = 0; j < 4; j++) {
            int nx = x + dx[j] * i;
            int ny = y + dy[j] * i;
            if(nx >= 0 && ny >= 0 && nx < H && ny < W && graph[nx][ny] != 0) {
                boom(nx, ny);
            }
        }
    }
}

void fall() {
    // for(int i = 0; i < W; i++) {
    //     while(1) {
    //         bool isOk = false;
    //         for(int j = H - 1; j > 0; j--) {
    //             if(graph[j][i] == 0 && graph[j - 1][i] != 0) {
    //                 graph[j][i] = graph[j - 1][i];
    //                 graph[j - 1][i] = 0;
    //                 isOk = true;
    //             }
    //         }
    //         if(!isOk) break;
    //     }
    // }
    for(int i = 0; i < H; i++) for(int j = 0; j < W; j++) temp[i][j] = 0;

    for(int j = 0; j < W; j++) {
        int last_idx = H - 1;
        for(int i = H - 1; i >= 0; i--) {
            if(graph[i][j]) {
                temp[last_idx--][j] = graph[i][j];
            }
        }
    }

    for(int i = 0; i < H; i++) for(int j = 0; j < W; j++) graph[i][j] = temp[i][j];
}

void process(int cnt) {
    if(cnt == N) {
        int answer = 0;
        for(int i = 0; i < H; i++) 
            for(int j = 0; j < W; j++) 
                if(graph[i][j] != 0) answer++;
            
        ret = min(ret, answer);
        return;
    }

    int tmp[15][12];
    for(int i = 0; i < W; i++) {
        int x = 0, y = i;
        while(x >= 0 && y >= 0 && x < H && y < W && graph[x][y] == 0) {
            x++;
        }
        memcpy(tmp, graph, sizeof(graph));
        boom(x, y);
        fall();
        process(cnt + 1);
        memcpy(graph, tmp, sizeof(tmp));
    }
}

void input() {
    cin >> T;
    for(int tc = 1; tc <= T; tc++) {
        ret = 987654321;
        cin >> N >> W >> H;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                cin >> graph[i][j];
            }
        }
        process(0);
        cout << '#' << tc << ' ' << ret << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
}

// 1
// 2 9 10
// 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0
// 0 1 0 0 0 0 0 0 0
// 0 1 0 0 0 0 0 0 0
// 1 1 0 0 1 0 0 0 0
// 1 1 0 1 1 1 0 1 0
// 1 1 0 1 1 1 0 1 0
// 1 1 1 1 1 1 1 1 0
// 1 1 3 1 6 1 1 1 1
// 1 1 1 1 1 1 1 1 1