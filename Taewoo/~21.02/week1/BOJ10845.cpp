#include<iostream>
#include<queue>
using namespace std;
queue<int> q;
int main() {
    int N; cin>>N;
    
    for(int i=0; i<N; i++) {
        string input; cin>>input;
        if(input == "push"){
            int num; cin>>num;
            q.push(num);
        }
        else if(input == "pop") {
            if(q.size()) {
                cout<<q.front()<<'\n';
                q.pop();
            }
            else cout<<-1<<'\n';
        }
        else if(input == "size") cout<<q.size()<<'\n';
        else if(input == "empty") {
            if(q.size()) cout<<0<<'\n';
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
    return 0;
}