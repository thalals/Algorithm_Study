#include <bits/stdc++.h>
using namespace std;

int paper[10][10], visited[10][10], ans = 2e9;
int cnt_paper[5] = {5, 5, 5, 5, 5};
void input() {
    for(int i = 0; i < 10; i++) for(int j = 0; j < 10; j++) cin >> paper[i][j];
}

void go(int x, int y, int cnt) {
    if(y == 10) {
        go(x+1, 0, cnt);
        return;
    }
    if(x == 10) {
        ans = min(ans, cnt);
        return;
    }
    if(!paper[x][y]) {
        go(x, y+1, cnt);
        return;
    }

    for(int size = 1; size <= 5; size++) {
        if(x+size > 10 || y + size > 10 || cnt_paper[size-1] == 0) continue;

        bool flag = false;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(paper[x+i][y+j] == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(flag) break;

        // µ¤À» ¼ö ÀÖ´Â °æ¿ì µ¤ÀÚ
        for(int i = 0; i < size; i++) for(int j = 0; j < size; j++) paper[x+i][y+j] = 0;
        cnt++;
        cnt_paper[size-1]--;

        go(x, y + size, cnt);

        for(int i = 0; i < size; i++) for(int j = 0; j < size; j++) paper[x+i][y+j] = 1;
        cnt--;
        cnt_paper[size-1]++;
    }
}

void pro() {
    go(0, 0, 0);
    if(ans == 2e9) cout << -1;
    else cout << ans;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}