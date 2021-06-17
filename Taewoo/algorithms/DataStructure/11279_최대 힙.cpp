/*
Problem : https://www.acmicpc.net/problem/11279
Comment : 우선순위 큐에 0이면 삭제, 0이 아닌 수는 우선순위 큐에 넣기
*/
#include <bits/stdc++.h>
using namespace std;

priority_queue<int, vector<int>, less<>> pq;
int N;
void input() {
    cin >> N;
}

void pro() {
    for(int i = 0; i < N; i++) {
        int input;
        cin >> input;

        if(input == 0 && pq.size() != 0) {
            cout << pq.top() << "\n";
            pq.pop();
        }
        else if(input == 0 && pq.size() == 0) cout << 0 << "\n";
        else pq.push(input);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}