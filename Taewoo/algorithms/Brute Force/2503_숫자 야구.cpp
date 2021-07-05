#include<bits/stdc++.h>
using namespace std;

struct Info {
    string num;
    int strike, ball;
};
int n;
vector<Info> question;
void input() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        string num; int strike, ball;
        cin >> num >> strike >> ball;
        question.push_back({num, strike, ball});
    }
}

bool isOk(string target) {
    if(target[1] == '0' || target[2] == '0') return 1;
    if(target[0] == target[1] || target[1] == target[2] || target[2] == target[0]) return 1;
    else return 0;
}

int answer;
void pro() {
    for(int i = 123; i <= 987; i++) {
        string target = to_string(i);
        int ret = 0;
        if(isOk(target)) continue;

        for(int j = 0; j < n; j++) {
            int stkCnt = 0, ballCnt = 0;

            for(int k = 0; k < 3; k++) {
                if(target[k] == question[j].num[k]) stkCnt++;
                if(target[k] == question[j].num[(k+1) % 3] || target[k] == question[j].num[(k+2) % 3]) ballCnt++;
            }
            if(stkCnt == question[j].strike && ballCnt == question[j].ball) ret++;
        }
        if(ret == n) answer++;
    }
    cout << answer << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}