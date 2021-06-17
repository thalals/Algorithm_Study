#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>
#include <cmath>
using namespace std;
int N, Q, L;
int map[64][64];
int temp[64][64];
int check_melt[64][64];
int visit[64][64];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void input() {
    cin >> N >> Q;

    N = (1 << N);
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }
}

void _rotate(int x, int y, int L) {
    for(int i = 0; i < L; i++) {
        for(int j = 0; j < L; j++) {
            temp[i][j] = map[x + L - 1 - j][y + i];
        }
    }

    for(int i = 0; i < L; i++) {
        for(int j = 0; j < L; j++) {
            map[x + i][y + j] = temp[i][j];
        }
    }
}

void pro(int L) {
    // 격자 별 회전
    L = (1 << L);
    for(int i = 0; i < N; i += L) {
        for(int j = 0; j < N; j+= L) {
            _rotate(i, j, L);
        }
    }
    
    // 융해
    memset(check_melt, 0, sizeof(check_melt));
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(map[i][j] == 0) continue;
            int cnt = 0;
            for(int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx < 0 || ny < 0 || nx == N || ny == N) continue;
                if(map[nx][ny] > 0) cnt++;
            }
            if(cnt < 3) check_melt[i][j] = 1;
        }
    }

    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            if(check_melt[i][j] == 1) map[i][j]--;
}

int get_sum() {
    int sum = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            sum += map[i][j];     
        }
    }
    return sum;
}

int dfs(int x, int y) {
    visit[x][y] = 1;
    int cnt = 1;
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && map[nx][ny] > 0) {
            cnt += dfs(nx, ny);
        }
    }
    return cnt;
}

int get_big() {
    int sum = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(map[i][j] > 0 && !visit[i][j])
                sum = max(sum, dfs(i, j));
        }
    }
    return sum;
}

void process() {
    while(Q--) {
        cin >> L;
        pro(L);
    }
    
    cout << get_sum() << '\n';
    cout << get_big() << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    input();
    process();
    return 0;
}