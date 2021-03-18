#include <bits/stdc++.h>
using namespace std;

vector<int> wheel[4];
vector<pair<int, int>> command;
int k;
void input() {
    for(int i = 0; i < 4; i++) {
        string tmp; cin >> tmp;
        for(int j = 0; j < tmp.size(); j++){
            wheel[i].push_back(tmp[j] - '0');
        }
    }

    cin >> k; // 회전 횟수
    // 시계 방향 1, 반시계 방향 -1
    for(int i = 0; i < k; i++) {
        int num, dir;
        cin >> num >> dir;
        command.push_back({num - 1, dir});
    }
}

void move(int idx, int dir) {
    if(dir == 1) {
        // 시계 방향
        int tmp = wheel[idx][7];
        for(int i = 7; i > 0; i--) {
            wheel[idx][i] = wheel[idx][i - 1];
        }
        wheel[idx][0] = tmp;
    }
    else if(dir == -1) {
        int tmp = wheel[idx][0];
        for(int i = 0; i < 7; i++) {
            wheel[idx][i] = wheel[idx][i + 1];
        }
        wheel[idx][7] = tmp;
    }
}

void turn(int idx, int dir) {
    if(idx == 0) {
        if(wheel[idx][2] != wheel[idx + 1][6]){
            // 0번 바퀴와 1번 바퀴의 맞다는 부분이 다르면
            if(wheel[idx + 1][2] != wheel[idx + 2][6]) {
                if(wheel[idx + 2][2] != wheel[idx + 3][6]) {
                    move(idx, dir);
                    move(idx + 1, dir * -1);
                    move(idx + 2, dir);
                    move(idx + 3, dir * -1);
                }
                else {
                    move(idx, dir);
                    move(idx + 1, dir * -1);
                    move(idx + 2, dir);
                }
            }
            else {
                move(idx, dir);
                move(idx + 1, dir * -1);
            }
        }
        else {
            move(idx, dir);
        }
    }

    else if(idx == 1) {
        if(wheel[idx][6] != wheel[idx - 1][2]) {
            move(idx - 1, dir * -1);
        }

        if(wheel[idx][2] != wheel[idx + 1][6]) {
            if(wheel[idx + 1][2] != wheel[idx + 2][6]) {
                move(idx, dir);
                move(idx + 1, dir * -1);
                move(idx + 2, dir);
            }
            else {
                move(idx, dir);
                move(idx + 1, dir * -1);
            }
        }
        else {
            move(idx, dir);
        }
    }
    else if(idx == 2) {
        if(wheel[idx][2] != wheel[idx + 1][6]) {
            move(idx + 1, dir * -1);
        }

        if(wheel[idx][6] != wheel[idx - 1][2]) {
            if(wheel[idx - 1][6] != wheel[idx - 2][2]) {
                move(idx, dir);
                move(idx - 1, dir * -1);
                move(idx - 2, dir);
            }
            else {
                move(idx, dir);
                move(idx - 1, dir * -1);
            }
        }
        else {
            move(idx, dir);
        }
    }
    else if(idx == 3) {
        if(wheel[idx][6] != wheel[idx - 1][2]) {
            if(wheel[idx - 1][6] != wheel[idx - 2][2]) {
                if(wheel[idx - 2][6] != wheel[idx - 3][2]) {
                    move(idx, dir);
                    move(idx - 1, dir * -1);
                    move(idx - 2, dir);
                    move(idx - 3, dir * -1);
                }
                else {
                    move(idx, dir);
                    move(idx - 1, dir * -1);
                    move(idx - 2, dir);
                }
            }
            else {
                move(idx, dir);
                move(idx - 1, dir * -1);
            }
        }
        else {
            move(idx, dir);
        }
    }
}

void pro() {
    for(int i = 0; i < command.size(); i++) {
        int number = command[i].first; // 바퀴 번호
        int dir = command[i].second; // 회전 방향
        turn(number, dir);
    }

    int answer = 0;
    if(wheel[0][0] == 1) answer += 1;
    if(wheel[1][0] == 1) answer += 2;
    if(wheel[2][0] == 1) answer += 4;
    if(wheel[3][0] == 1) answer += 8;

    cout << answer;
}

int main() {
    input();
    pro();
    return 0;
}