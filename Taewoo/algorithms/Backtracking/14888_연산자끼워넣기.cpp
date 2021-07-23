#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
vector<int> number;
vector<int> oper;
int ans_max = -2e9;
int ans_min = 2e9;
void input() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        int num; cin >> num;
        number.push_back(num);
    }

    for(int i = 0; i < 4; i++) {
        int op; cin >> op;
        oper.push_back(op);
    }
}

void go(int idx, int plus, int minus, int multi, int divide, int sum) {
    if(idx == number.size() - 1) {
        ans_max = max(ans_max, sum);
        ans_min = min(ans_min, sum);
        return;
    }

    if(plus > 0) go(idx+1, plus-1, minus, multi, divide, sum + number[idx+1]);
    if(minus > 0) go(idx+1, plus, minus-1, multi, divide, sum - number[idx+1]);
    if(multi > 0) go(idx+1, plus, minus, multi-1, divide, sum * number[idx+1]);
    if(divide > 0) go(idx+1, plus, minus, multi, divide-1, sum / number[idx+1]);
}

void pro() {
    go(0, oper[0], oper[1], oper[2], oper[3], number[0]);
    cout << ans_max << '\n' << ans_min;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}
