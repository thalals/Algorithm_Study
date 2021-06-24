/*
Problem : https://www.acmicpc.net/problem/10866
Comment : 단순 덱을 배우는 문법 문제
*/
#include <bits/stdc++.h>
using namespace std;

int N;
void input() {
    cin >> N;
}

deque<int> q;
void pro() {
    for(int i = 0; i < N; i++) {
        string input; 
        cin>>input;
        if(input == "push_front") {
            int x; cin>>x;
            q.push_front(x);
        }
        else if(input == "push_back") {
            int x; cin>>x;
            q.push_back(x);
        }
        else if(input == "pop_front") {
            if(q.size()) {
                cout<<q.front()<<'\n'; q.pop_front();
            }
            else cout<<-1<<'\n';
        }
        else if(input == "pop_back") {
            if(q.size()) {
                cout<<q.back()<<'\n'; q.pop_back();
            }
            else cout<<-1<<'\n';
        }
        else if(input == "size") cout<<q.size()<<'\n';
        else if(input == "empty") {
            if(!q.empty()) cout<<0<<'\n';
            else cout<<1<<'\n';
        }
        else if(input == "front") {
            if(q.size()) cout<<q.front()<<'\n';
            else cout<<-1<<'\n';
        }
        else if(input == "back") {
            if(q.size()) cout<<q.back()<<'\n';
            else cout<<-1<<'\n';
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