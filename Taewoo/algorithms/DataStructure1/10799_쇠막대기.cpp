#include <bits/stdc++.h>
using namespace std;

string s;
void input() {
    cin >> s;
}

stack<char> stk;
int answer;
void pro() {
    for(int i = 0; i < s.size(); i++) {
        if(s[i] == '(') {
            stk.push(s[i]);
        }
        else {
            if(s[i - 1] == '(') {
                stk.pop();
                answer += stk.size();
            }
            else {
                stk.pop();
                answer += 1;
            }
        }
    }
    cout << answer << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}