#include<bits/stdc++.h>
using namespace std;

struct node {
    int negu;
    bool is_robot;
};

int n, k;
deque<node> dq;
void input() {
    cin >> n >> k;
    for(int i = 1; i <= 2 * n; i++) {
        int negu; cin >> negu;
        dq.push_back({negu, 0});
    }
}

void conveyer_move() {
    dq.push_front(dq.back());
    dq.pop_back();
    dq.at(n - 1).is_robot = 0;
}

void robot_move() {
    for(int i = n - 2; i >= 0; i--) {
        if(!dq.at(i + 1).is_robot && dq.at(i).is_robot && dq.at(i + 1).negu > 0) {
            dq.at(i).is_robot = 0;
            dq.at(i + 1).is_robot = 1;
            dq.at(i + 1).negu--;
        }
    }
    dq.at(n - 1).is_robot = 0;
}

void put_robot() {
    if(dq.at(0).is_robot == 0 && dq.at(0).negu > 0) {
        dq.at(0).is_robot = 1;
        dq.at(0).negu--;
    }
}


void pro() {
    int answer = 1;
    while(true) {
        conveyer_move();
        robot_move();
        put_robot();
        // 내구도가 4인지 확인하기
        int count = 0;
        bool flag = false;
        for(int i = 0; i < dq.size(); i++) {
            if(dq.at(i).negu <= 0) {
                count++;
            }
            if(count >= k) {
                flag = true;
                break;
            }
        }
        if(flag == true) break;
        answer++;
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
    return 0;
}