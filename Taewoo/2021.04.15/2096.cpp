#include <bits/stdc++.h>
using namespace std;
// 현재 행에서 최대 값을 구하기 위해서 number의 이전 행 값과 
// 메모의 이전 행의 값 이외에 필요없음.
int n;
int maxDP[100001][3];
int minDP[100001][3];
void input() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < 3; j++) {
            cin >> maxDP[i][j];
            minDP[i][j] = maxDP[i][j];
        }
    }
}

void pro() {
    for(int i = 1; i < n; i++) {
        maxDP[i][0] += max(maxDP[i - 1][0], maxDP[i - 1][1]);
        maxDP[i][1] += max(max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]);
        maxDP[i][2] += max(maxDP[i - 1][1], maxDP[i - 1][2]);

        minDP[i][0] += min(minDP[i - 1][0], minDP[i - 1][1]);
        minDP[i][1] += min(min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]);
        minDP[i][2] += min(minDP[i - 1][1], minDP[i - 1][2]);
    }
    cout << max(max(maxDP[n - 1][0], maxDP[n - 1][1]), maxDP[n - 1][2]) << ' ';
    cout << min(min(minDP[n - 1][0], minDP[n - 1][1]), minDP[n - 1][2]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
    return 0;
}