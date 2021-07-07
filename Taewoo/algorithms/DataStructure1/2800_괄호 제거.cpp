#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    string s; cin >> s;
    set<string> answers;
    stack<int> st;
    vector<pair<int, int>> pos;

    for(int i = 0; i < s.size(); i++) {
        if(s[i] == '(') st.push(i);
        else if(s[i] == ')') {
            int tmp = st.top(); st.pop();
            pos.push_back({tmp, i});
        }
    }

    int size = 1 << pos.size();
    for(int i = 1; i < size; i++) {
        string newStr = s;
        for(int j = 0; j < pos.size(); j++) {
            if(i & (1 << j)) { // i % 2 == 1
                newStr[pos[j].first] = ' ';
                newStr[pos[j].second] = ' ';
            }
            // i /= 2;
        }

        string newnewStr;
        for(char c : newStr) {
            if(c != ' ') newnewStr += c;
        }
        answers.insert(newnewStr);
    }
    for(string s : answers) cout << s << '\n';
}