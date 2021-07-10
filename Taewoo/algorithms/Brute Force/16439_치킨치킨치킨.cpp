#include<bits/stdc++.h>
#define MAX 30
using namespace std;

int N, M;
int preference[MAX][MAX];
void input() {
    cin >> N >> M;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cin >> preference[i][j];
        }
    }
}

int answer;
void pro() {
    for(int i = 0; i < M; i++) {
        for(int j = 0; j < i; j++) {
            for(int k = 0; k < j; k++) {
                cout << i << ' ' << j << ' ' << k << '\n';
                int sum = 0;
                for(int p = 0; p < N; p++) sum += max({preference[p][i], preference[p][j], preference[p][k]});
                
                answer = max(answer, sum);
            }
        }
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
    return 0;
}