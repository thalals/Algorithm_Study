/*
Problem : https://www.acmicpc.net/problem/16987
Comment : 
1. 가장 왼쪽의 계란을 든다.
2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 
   단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 
   이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 
   단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
*/
#include <bits/stdc++.h>
using namespace std;

struct egg {
    int dura, weight;
    egg(int dura, int weight) : dura(dura), weight(weight) {}
};

int N, answer;
vector<egg> Eggs;
void input() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        int d, w; cin >> d >> w;
        Eggs.push_back(egg(d, w));
    }
}

void go(int idx) {
    if(idx == N) {
        int cnt = 0;
        for(int i = 0; i < N; i++)
            if(Eggs[i].dura <= 0) cnt++;
        answer = max(answer, cnt);
        return;
    }

    if(Eggs[idx].dura <= 0) {
        go(idx + 1);
        return;
    }

    bool flag = false;
    for(int i = 0; i < N; i++) {
        if(idx == i || Eggs[i].dura <= 0) continue;
        
        Eggs[idx].dura = Eggs[idx].dura - Eggs[i].weight;
        Eggs[i].dura = Eggs[i].dura - Eggs[idx].weight;
        flag = true;
        go(idx + 1);
        Eggs[idx].dura = Eggs[idx].dura + Eggs[i].weight;
        Eggs[i].dura = Eggs[i].dura + Eggs[idx].weight;
    }
    if(flag == false) go(idx + 1);
}

void pro() {
    go(0);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}

