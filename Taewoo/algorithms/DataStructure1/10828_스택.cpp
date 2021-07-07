/*
Problem : https://www.acmicpc.net/problem/1158
Comment : 그저 스택이용...
*/
#include <bits/stdc++.h>
using namespace std;

int N;
void input() {
    cin >> N;
}

stack<int> stk;
void pro() {
    for(int i = 0; i < N; i++) {
        string input;
        cin >> input;
        if(input == "push") {
            int num; cin>>num;
            stk.push(num);
        }
        else if(input == "pop"){
            if(stk.size()) {
                cout<<stk.top()<<'\n';
                stk.pop();
            }
            else cout<<-1<<'\n';
        }
        else if(input == "size") {
            cout<<stk.size()<<'\n';
        }
        else if(input == "empty") {
            cout<<stk.empty()<<'\n';
        }
        else if(input == "top") {
            if(stk.size()) cout<<stk.top()<<'\n';
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