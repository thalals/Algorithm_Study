#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const string &a, const string &b) {
    if(a.size() == b.size()) return a < b;
    else return a.size() < b.size();
}

int main() {
    int n;
    cin >> n;
    vector<string> s;
    s.resize(n, "");

    for(int i = 0; i < n; i++) {
        cin >> s[i];    
    }

    sort(s.begin(), s.end(), cmp);
    s.erase(unique(s.begin(), s.end()), s.end());
    for(string i : s) cout << i << "\n";
}