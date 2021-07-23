#include<iostream>
#include<vector>
using namespace std;
int N, M;
vector<int> v;
void backtracking(int idx){
    if(idx == M){
        for(int i: v){
            cout<<i<<' ';
        }cout<<'\n';
        return;
    }

    int back = v.empty() ? 1 : v.back();

    for(int i=back; i<=N; i++){
        v.push_back(i);
        backtracking(idx + 1);
        v.pop_back();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin>>N>>M;
    backtracking(0);
    
}