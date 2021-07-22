#include<iostream>
#include<vector>
using namespace std;
int N, M;
vector<int> v;
void backtracking(int idx){
    if(v.size() == M){
        for(int i: v){
            cout<<i<<' ';
        }cout<<'\n';
        return;
    }

    for(int i=1; i<=N; i++){
        if(idx<i){
            v.push_back(i);
            backtracking(i);
            v.pop_back();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin>>N>>M;
    backtracking(0);
    
}