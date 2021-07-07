#include <bits/stdc++.h>
using namespace std;

stack<int> s, result;
stack<int> temp;
int num, n, cnt;
void input() {
    cin >> num;
    for(int i = 0; i < num; i++) {
        cin >> n;
        s.push(n);
    }
}

void pro() {
    while(!s.empty()) {
        int val = s.top();
        s.pop();

        // 수신한 탑 찾기
        while(!s.empty()) {
            if(val < s.top()) {
                result.push(s.size());
                break;
            }
            temp.push(s.top());
            s.pop();
        }

        if(s.empty()) result.push(0);

        // temp-> s로 보내기
        while(!temp.empty()) {
            s.push(temp.top());
            temp.pop();
        }
    }

    while(!result.empty()) {
        cout << result.top() << ' ';
        result.pop();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}