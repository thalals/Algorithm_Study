/*
Comment : 진법을 구하는 방법 여러개가 존재하네...
*/
#include <bits/stdc++.h>
using namespace std;

string N;
int B, answer;
void input() {
    cin >> N >> B;
}

void pro() {
    for(int i = 0; i < N.size(); i++) {
        if('0' <= N[i] and N[i] <= '9'){
            answer = answer * B + (N[i] - '0');
        }
        else answer = answer * B + (N[i] - 'A' + 10);
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}