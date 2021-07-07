/*
Problem : https://www.acmicpc.net/problem/1158
Comment : 큐에서 빼고넣고 k번째가 되면 제거해주면된다.
*/
#include <bits/stdc++.h>
using namespace std;

int N, K;
void input() {
    cin >> N >> K;
}

queue<int> q;
int cnt = 1;
void pro() {
    for(int i = 1; i <= N; i++) q.push(i);

    cout<<"<";
    while(!q.empty()) {
        if(q.size() == 1) {
            cout << q.front() << ">";
            q.pop();
            break;
        }
        else if(cnt % K){
            q.push(q.front()); q.pop();
            cnt++;
        }
        else {
            cout << q.front() << ", ";
            q.pop();
            cnt++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}