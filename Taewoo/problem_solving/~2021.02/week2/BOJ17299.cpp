#include<iostream>
#include<vector>
#include<stack>
using namespace std;
int counted[1000004];
int main() {
    int N; cin>>N;
    vector<int> v(N);
    vector<int> answer(N, -1);
    stack<int> s;

    for(int i=0; i<N; i++) {
        cin>>v[i];
        counted[v[i]]++;
    }

    for(int i=0; i<N; i++) {
        while(!s.empty() && counted[v[s.top()]] < counted[v[i]]) {
            answer[s.top()] = v[i];
            s.pop();
        }
        s.push(i);
    }
    
    for(auto it: answer) cout<<it<<' ';
    return 0;
}