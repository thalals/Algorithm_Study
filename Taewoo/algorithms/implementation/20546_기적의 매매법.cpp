#include <bits/stdc++.h>
#define N 14
using namespace std;

int money;
vector<int> stock;
void input() {
    cin >> money;
    stock.resize(N, 0);
    for(int i = 0; i < N; i++) cin >> stock[i];
}

int buy_and_pray() {
    int Jmoney = money;
    int cnt = 0;
    for(int i = 0; i < N; i++) {
        if(stock[i] > Jmoney) continue;
        cnt += Jmoney / stock[i];
        Jmoney %= stock[i];
    }
    return Jmoney + cnt * stock[N - 1];
}

int timing() {
    int Smoney = money;
    int down = 0, up = 0;
    int cnt = 0;
    for(int i = 1; i < 14; i++) {
        if(stock[i - 1] < stock[i]) {
            up++; down = 0;
        }
        else if(stock[i - 1] > stock[i]) {
            down++; up = 0;
        }
        else if(stock[i - 1] == stock[i]) down = up = 0;
        if(up >= 3) {
            Smoney += cnt * stock[i];
            cnt = 0;
        }
        if(stock[i] <= Smoney && down >= 3) {
            cnt += Smoney / stock[i];
            Smoney %= stock[i];
        }
    }
    return Smoney + cnt * stock[N - 1];
}

void pro() {
    int BNP = buy_and_pray();
    int Timing = timing();

    if(BNP == Timing) cout << "SAMESAME";
    else BNP > Timing ? cout << "BNP" : cout << "TIMING";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}