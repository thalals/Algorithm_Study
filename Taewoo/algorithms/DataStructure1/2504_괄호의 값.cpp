/*
Problem: https://www.acmicpc.net/problem/2504
Comment : (, [ 스택에 푸시
          ), ]
            1. 스택에서 top ( [ 짝 맞는지 확인하기
*/
#include <bits/stdc++.h>
using namespace std;

string s;
void input() {
    cin >> s;
}

int answer;
stack<char> st;
bool isOk = true;
int ret = 1;
void pro() {
    for(int i = 0; i < s.size(); i++) {
        char c = s[i];
        if(c == '(') {
            ret *= 2;
            st.push(c);
        }
        else if(c == '[') {
            ret *= 3;
            st.push(c);
        }
        else if(c == ')') {
            if(st.empty() || st.top() != '(') {
                isOk = false;
                break;
            }
            else {
                if(s[i - 1] == '(') answer += ret;
                ret /= 2;
                st.pop();
            }
        }
        else if(c == ']') {
            if(st.empty() || st.top() != '[') {
                isOk = false;
                break;
            }
            else {
                if(s[i - 1] == '[') answer += ret;
                ret /= 3;
                st.pop();
            }
        }
    }

    if(!isOk || !st.empty()) cout << 0;
    else cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}
