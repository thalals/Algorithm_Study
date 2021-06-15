#include <iostream>
using namespace std;

string s;
int alpha[26];
void input() {
    cin >> s;
    fill(alpha, alpha + 26, -1);
}

void pro() {
    for(int i = 0; i < s.size(); i++) {
        if(alpha[s[i] - 'a'] != -1) continue;
        else {
            alpha[s[i] - 'a'] = i;
        }
    }
    for(int i = 0; i < 26; i++)
        cout << alpha[i] << " ";
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
}
