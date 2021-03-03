#include<bits/stdc++.h>
using namespace std;

int board[20][20];
int dx[4] = {0, 1, 1, 1};
int dy[4] = {1, 1, 0, -1};


void input() {
    for(int i = 1; i <= 19; i++) {
        for(int j = 1; j <= 19; j++) {
            cin >> board[i][j];
        }
    }
}

void solve() {
    // 오목이 맞는지 확인
    for(int i = 1; i <= 19; i++) {
        for(int j = 1; j <= 19; j++) {
            if(board[i][j]) {
                for(int k = 0; k < 4; k++) {
                    int count = 1;
                    int X = i;
                    int Y = j;

                    while(1) {
                        int nextX = X + dx[k]; // 다음 돌 좌표
                        int nextY = Y + dy[k]; // 다음 돌 좌표
             
                        if(nextX >=1 && nextX <= 19 && nextY >= 1 && nextY <= 19 && board[i][j] == board[nextX][nextY]) {
                            count++;
                            X = nextX, Y = nextY;
                            continue;
                        }
                        else if(count == 5) {
                            if(k == 0 && board[i][j] == board[i][j - 1]) break;
                            else if(k == 1 && board[i][j] == board[i - 1][j - 1]) break;
                            else if(k == 2 && board[i][j] == board[i - 1][j]) break;
                            else if(k == 3 && board[i][j] == board[i - 1][j + 1]) break;

                            cout << board[i][j] << '\n';
                            if(k == 3) cout << X << ' ' << Y;
                            else cout << i << ' ' << j;
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }
    cout << 0;
}
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    input();
    solve();
}