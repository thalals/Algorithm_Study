/*
Problem : https://www.acmicpc.net/problem/2164
Comment : 큐를 이용해서 한번 뺴고 버리고, 한번 뺴고 큐에 다시 넣고...하나만 남을 때까지
*/
#include <bits/stdc++.h>
using namespace std;

int N;
void input() {
    cin >> N;
}

queue<int> q;
void pro() {
    for(int i = 1; i <= N; i++) q.push(i);

    while(q.size() > 1) {
        q.pop();
        int val = q.front();
        q.pop();
        q.push(val);
    }
    cout << q.front() << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}