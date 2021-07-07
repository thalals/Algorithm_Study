/*
Problem : https://www.acmicpc.net/problem/18258
Comment : 그저 큐 사용하기
*/
#include <bits/stdc++.h>
using namespace std;

queue<int> q;
int N;
void input() {
    cin >> N;
}

void pro() {
    for(int i = 0; i < N; i++) {
        string input;
        cin >> input;
        if(input == "push") {
            int num; 
            cin >> num;
            q.push(num);
        }
        else if(input == "pop") {
            if(!q.empty()) {
                cout << q.front() << "\n";
                q.pop();
            }
            else cout << -1 << "\n";
        }
        else if(input == "size") cout << q.size() << "\n";
        else if(input == "empty") {
            if(!q.empty()) cout << q.empty() << "\n";
            else cout << q.empty() << "\n";
        }
        else if(input == "front") {
            if(!q.empty()) cout << q.front() << "\n";
            else cout << -1 << "\n";
        }
        else {
            if(!q.empty()) cout << q.back() << "\n";
            else cout << -1 << "\n";
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