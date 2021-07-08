#include <bits/stdc++.h>
using namespace std;

int T;
int coin[3][3];
int used[9];
void input() {
    cin >> T;
}

bool isOk() {
    int t = 0; int h = 0;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            if(coin[i][j]) t++;
            else h++;
        }
    }
    if((t == 9) || (h == 9)) return true;
    else return false;
}

int answer;
void go(int cnt) {
    if(isOk()) answer = min(answer, cnt);
    
    if(cnt == 8) return;

    for(int i = 0; i < 8; i++) {
        if(used[i]) continue;
        used[i] = true;
        if(i == 0 || i == 1 || i == 2) { // 열
            for(int j = 0; j < 3; j++) coin[j][i] = !coin[j][i];
            go(cnt + 1);
            for(int j = 0; j < 3; j++) coin[j][i] = !coin[j][i];
        }

        if(i == 3 || i == 4 || i == 5) { // 행
            for(int j = 0; j < 3; j++) coin[i % 3][j] = !coin[i % 3][j];
            go(cnt + 1);
            for(int j = 0; j < 3; j++) coin[i % 3][j] = !coin[i % 3][j];
        }

        if(i == 6) { // 우하향 대각선
            for(int j = 0; j < 3; j++) coin[j][j] = !coin[j][j];
            go(cnt + 1);
            for(int j = 0; j < 3; j++) coin[j][j] = !coin[j][j];
        }
        if(i == 7) { // 좌하향 대각선
            for(int j = 0; j < 3; j++) coin[j][2 - j] = !coin[j][2 - j];
            go(cnt + 1);
            for(int j = 0; j < 3; j++) coin[j][2 - j] = !coin[j][2 - j];
        }
        used[i] = false;
    }
}

void pro () {
    for(int t = 0; t < T; t++) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char c; cin >> c;
                if(c == 'T') coin[i][j] = 1;
                else coin[i][j] = 0;
            }
        }
        answer = 2e9;
        go(0);
        answer == 2e9 ? cout << -1 << "\n" : cout << answer << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}