#include<iostream>
#include<queue>
using namespace std;

int main() {
    int N, K;
    int cnt = 1;
    queue<int> q;
    cin>>N>>K;

    for(int i = 0; i < N; i++) q.push(i+1);

    cout<<"<";
    while(q.size()) {
        if(q.size() == 1) {
            cout<<q.front()<<">";
            q.pop();
            break;
        }
        else if(cnt % K){
            q.push(q.front()); q.pop();
            cnt++;
        }
        else {
            cout<<q.front()<<", ";
            q.pop();
            cnt++;
        }
    }
    return 0;
}