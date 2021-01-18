#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int main() {
    int N; cin>>N;
    vector<int> vec(N), answer(N, -1);
    stack<int> s;
    
    for(int i=0; i<N; i++)
        cin>>vec[i];

    for(int i=0; i<N; i++) {
        while(!s.empty() && vec[s.top()] < vec[i]) {
            answer[s.top()] = vec[i];
            s.pop();
        }
        s.push(i);
    }

    for(auto it: answer) cout<<it<<' ';

    return 0;
}