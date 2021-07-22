#include<iostream>
using namespace std;

int arr[21];
int N, S, answer;
void go(int idx, int value) {
    if(idx == N + 1) return;
    if(value + arr[idx] == S) answer++;

    go(idx + 1, value + arr[idx]);
    go(idx + 1, value);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> S;
    for(int i = 1; i <= N; i++) cin >> arr[i];
    
    go(1, 0);
    cout << answer;
}