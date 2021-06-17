#include <iostream>
#include <vector>
using namespace std;

string s, t;
int main() {
    while(cin >> s >> t) {
        int i = 0;
        int j = 0;
        for(; j < t.size(); j++) {
            if(s[i] == t[j]) {
                i++;
                if(i == s.size()) {
                    cout << "Yes" << "\n";
                    break;
                }
            }
        }
        if(j == t.size()) cout << "No" << "\n";
    }
    return 0;
}