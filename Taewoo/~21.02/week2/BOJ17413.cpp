#include <iostream>
#include <stack>
using namespace std;

int main( ) {
    string s;
    stack<char> stk;
    bool flag=false;

    getline(cin, s);
    for(char i: s) {
        if(i == '<') {
            while(!stk.empty()) {
                cout<<stk.top(); stk.pop();
            }
            cout<<i;
            flag = true;
        }
        else if(i == '>'){
            cout<<i;
            flag = false;
        }
        else if(flag){
            cout<<i;
        }
        else {
            //flag == false 일 때
            if(i == ' '){
                string ret;
                while(!stk.empty()) {
                    cout<<stk.top(); stk.pop();
                }
                cout<<ret<<' ';
            }
            else {
                stk.push(i);
            }
        }
    }
    while(!stk.empty()) {
        cout<<stk.top(); stk.pop();
    }
    return 0;
}