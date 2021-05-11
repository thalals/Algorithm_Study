#include<bits/stdc++.h>
using namespace std;
bool compare(const char &a, const char &b){
    return a > b;
}   

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    string s; cin >> s;
    sort(s.begin(), s.end(), compare);
    
    for(char i : s) cout << i;
}