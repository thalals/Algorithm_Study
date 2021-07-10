#include<bits/stdc++.h>
#define MAX 33
using namespace std;

int N, M;
int preference[MAX][MAX];
void input() {
    cin >> N >> M;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            cin >> preference[i][j];
        }
    }
}

int answer;
int selected[4];
void go(int k) {
    if(k == 4) {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            int _max = 0;
            for(int j = 1; j < k; j++) {
                _max = max(_max, preference[i][selected[j]]);
            }
            sum += _max;
        }
        answer = max(answer, sum);
        return;
    }
    int back = selected[k - 1];
    for(int i = back + 1; i <= M; i++) {
        selected[k] = i;
        go(k + 1);
        selected[k] = 0;
    }
}
void pro() {
    go(1);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
    return 0;
}