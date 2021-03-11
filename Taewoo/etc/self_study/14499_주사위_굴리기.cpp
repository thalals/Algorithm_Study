#include <bits/stdc++.h>
using namespace std;
 

int N, M, x, y, K;
int board[21][21];
int dx[5] = {0, 0, 0, -1, 1};
int dy[5] = {0, 1, -1, 0, 0};
int dice[7];
vector<int> doing;

void input() {
    cin >> N >> M >> x >> y >> K;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            cin >> board[i][j];

    // 동: 1, 서: 2, 북: 3, 남: 4
    for(int i = 0; i < K; i++) {
        int num; cin >> num;
        doing.push_back(num);
    }
}

void solve() {
    for(int i = 0; i < K; i++) {
        int nx = x + dx[doing[i]];
        int ny = y + dy[doing[i]];
        if(nx < 0 || nx == N || ny < 0 || ny == M) continue;
        int new_dice[7] = {0, };
        if(doing[i] == 1) {
            // 동쪽
            new_dice[3] = dice[1];
            new_dice[1] = dice[4];
            new_dice[2] = dice[2]; new_dice[5] = dice[5];
            new_dice[4] = dice[6];
            new_dice[6] = dice[3];
        }
        else if(doing[i] == 2) {
            // 서쪽
            new_dice[1] = dice[3];
            new_dice[4] = dice[1];
            new_dice[2] = dice[2]; new_dice[5] = dice[5];
            new_dice[3] = dice[6];
            new_dice[6] = dice[4];
        }
        else if(doing[i] == 3) {
            // 북쪽
            new_dice[2] = dice[1];
            new_dice[1] = dice[5];
            new_dice[5] = dice[6];
            new_dice[4] = dice[4]; new_dice[3] = dice[3];
            new_dice[6] = dice[2];
        }
        else if(doing[i] == 4) {
            // 남쪽
            new_dice[1] = dice[2];
            new_dice[5] = dice[1];
            new_dice[6] = dice[5];
            new_dice[4] = dice[4]; new_dice[3] = dice[3];
            new_dice[2] = dice[6];
        }
        if(board[nx][ny] == 0) {
            board[nx][ny] = new_dice[6];
        } else {
            new_dice[6] = board[nx][ny];
            board[nx][ny] = 0;
        }
        cout << new_dice[1] << '\n';
        for(int i = 0; i < 7; i++)
            dice[i] = new_dice[i];
        x = nx; y = ny;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
}