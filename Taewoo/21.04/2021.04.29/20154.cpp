#include <iostream>
#include <vector>
using namespace std;

int cnt[] = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

int main() {
    string s;
    cin >> s;
    vector<int> v;
    for(char c : s) {
        v.push_back(cnt[c - 'A']);
    }

    while(v.size() > 1) {
        vector<int> ans;
        if(v.size() % 2 == 0) {
            for(int i = 0; i < v.size(); i += 2) {
                ans.push_back((v[i] + v[i + 1]) % 10);
            }
        }
        else if(v.size() % 2 == 1) {
            for(int i = 0; i < v.size() - 1; i += 2) {
                ans.push_back((v[i] + v[i + 1]) % 10);
            }
            ans.push_back(v[v.size() - 1]);
        }
        v = ans;
        // for(auto i : v) cout << i << " ";
        // cout << "\n";
    }

    if(v[0] % 2 == 1) cout << "I'm a winner!";
    else cout << "You're the winner?";
}