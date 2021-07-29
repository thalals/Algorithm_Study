#include <bits/stdc++.h>
using namespace std;

int n, ans[] = {0, 0};
int chess[10][10];
int used1[20], used2[20]; // 대각선확인 2개
void input() {
    cin >> n;
    for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) cin >> chess[i][j];
}

void go(int x, int y, int cnt,int color) {
    if(y >= n) {
        if(y%2==0) go(x+1, 1, cnt, color);
        else go(x+1, 0, cnt, color);
        return;
    }
    if(x >= n) {
        ans[color] = max(ans[color], cnt);
        return;
    }

    if(chess[x][y] && !used1[x-y+n] && !used2[x+y+1]) {
        used1[x-y+n] = 1;
        used2[x+y+1] = 1;
        go(x, y+2, cnt+1, color);
        used1[x-y+n] = 0;
        used2[x+y+1] = 0;
    }
    go(x, y+2, cnt, color);
}

void pro() {
    go(0, 0, 0, 0); // 검은색
    go(0, 1, 0, 1); // 흰색
    cout << ans[0] + ans[1];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}