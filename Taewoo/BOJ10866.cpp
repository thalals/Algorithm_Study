#include<iostream>
#include<queue>
using namespace std;

int main() {
    deque<int> q;

    int N; cin>>N;

    for(int i=0; i<N; i++) {
        string input; cin>>input;

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
    return 0;
}