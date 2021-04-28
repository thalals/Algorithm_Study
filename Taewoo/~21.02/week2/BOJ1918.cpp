// 숫자는 문자열에 추가
// 연산자일 때
// 괄호 내가 우선순위가 가장 높기 때문에 ( 이면 push
// + - *  / 스택에 현재 연산자보다 우선순위가 높거나 같은 기호일 경우 pop해서 문자열 추가
// 우선순위 * / > + -

#include<iostream>
#include<stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    string s;
    string answer;
    stack<char> stk;
    cin>> s;

    for(int i=0; i<s.size(); i++) {
        if(s[i] >= 'A' && s[i] <= 'Z') {
            answer+=s[i];
        }
        else {
            if(s[i] == '(') stk.push(s[i]);
            else if(s[i] == '*' || s[i] == '/') {
                while(!stk.empty() && (stk.top() == '*' || stk.top() =='/')) {
                    answer += stk.top();
                    stk.pop();
                }
                stk.push(s[i]);
            }
            else if(s[i] == '+' || s[i] == '-') {
                while(!stk.empty() && stk.top() != '(') {
                    answer += stk.top();
                    stk.pop();
                }
                stk.push(s[i]);
            }
            else if(s[i] ==')') {
                while(!stk.empty() && stk.top() != '(') {
                    answer += stk.top();
                    stk.pop();
                }
                stk.pop();
            }
        }
    }
    while(!stk.empty()) {
        answer+=stk.top();
        stk.pop();
    }
    cout<<answer<<'\n';
    return 0;
}