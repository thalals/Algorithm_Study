#include <bits/stdc++.h>
using namespace std;

int n, m, t;
vector<int> v;
vector<int> tmp;
vector<vector<int>> ret;
void go(){
    if(tmp.size()==m){
        ret.push_back(tmp);
        return;
    }
    for(int i=0; i<v.size(); i++){
        tmp.push_back(v[i]);
        go();
        tmp.pop_back();
    }
}

int main() {
    cin>>n>>m;
    for(int i=0; i<n; i++){
        cin>>t;
        v.push_back(t);
    }
    sort(v.begin(), v.end());
    go();
    sort(ret.begin(), ret.end());
    ret.erase(unique(ret.begin(), ret.end()), ret.end());
    for(vector<int> a : ret){
        for(int b : a){
            cout<<b<<' ';
        }
        cout<<'\n';
    }
    return 0;
}