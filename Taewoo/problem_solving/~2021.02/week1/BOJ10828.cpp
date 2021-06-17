#include<iostream>
#include<stack>
using namespace std;

int main() {
    stack<int> stk;
    int N; cin>>N;

    for(int i=0; i<N; i++) {
        string input; cin>>input;
        
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
    return 0;
}