#include<iostream>
#include<stack>

using namespace std;
stack<char> stk;
string s;
int answer;
int main() {
    cin>>s;

    for(int i=0; i<s.size(); i++) {
        if(s[i] == '(') stk.push(s[i]);
        else if(s[i] == ')') {
            if(s[i-1] == '(') {
                stk.pop();
                answer+=stk.size();
            }
            else {
                stk.pop();
                answer+=1;
            }
        }
    }
    cout<<answer<<'\n';
}