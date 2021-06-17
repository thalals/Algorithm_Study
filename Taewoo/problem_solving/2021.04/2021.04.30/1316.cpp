#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int main() {
    int n;
    cin >> n;
    int cnt = 0;
    for(int i = 1; i <= n; i++) {
        string s;
        cin >> s;
        bool check = true;
        vector<bool> vec(26, false);
        for(int j = 0; j < s.size(); j++) {
            if(vec[s[j] - 'A'] == false) vec[s[j] - 'A'] = true;

            else if(s[j] != s[j - 1]) {
                check = false;
                break;
            }
        }
        if(check) cnt++;
    }

    cout << cnt << '\n';
}