#include<bits/stdc++.h>
using namespace std;

bool compare(const string &a, const string &b){
    if(a.size() == b.size()) return a < b;
    else return a.size() < b.size();
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    vector<string> v;
    for(int i = 0; i < n; i++){
        string s; cin >> s;
        v.push_back(s);
    }

    sort(v.begin(), v.end(), compare);
    v.erase(unique(v.begin(), v.end()), v.end());
    for(string i : v) cout << i << '\n';
}