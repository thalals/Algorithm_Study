#include <iostream>
#include <cstring>
#include <map>
using namespace std;

int main() {
    int n; cin >> n;
    cin.ignore();
    for(int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        int alpha[26];
        memset(alpha, 0, sizeof(alpha));
        for(int j = 0; j < s.size(); j++) {
            if(s[j] == ' ') continue;
            alpha[s[j] - 'a']++;
        }
        
        int max_ = 0;
        for(int ref : alpha) {
            if(max_ < ref) max_ = ref;
        }

        int cnt = 0;
        int answer = 0;
        for(int j = 0; j < 26; j++) {
            if(alpha[j] == max_) {
                cnt++;
                answer = j;
            }
        }

        if(cnt == 1) cout << char('a' + answer) << "\n";
        else { cout << "?" << "\n"; }
    }
}