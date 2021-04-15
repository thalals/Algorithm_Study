#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N;
int graph[21][21];
void input() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> graph[i][j];
        }
    }
};

void move(int (*graph)[21], int dir) {
    bool is_add = false;
    int idx;
    if(dir == 1) { // 왼쪽으로 밀때
        for(int i = 0; i < N; i++) {
            idx = 0;
            for(int j = 0; j < N; j++) {
                if(idx != 0 && !is_add && graph[i][j]== graph[i][idx - 1]) {
                    graph[i][idx - 1] *= 2;
                    graph[i][j] = 0;
                    is_add = true;
                }
                else if(graph[i][j]) {
                    if(idx == j) idx++;
                    else {
                        graph[i][idx] = graph[i][j];
                        graph[i][j] = 0;
                        idx++;
                    }
                    is_add = false;
                }
            }
        }
    }
    if(dir == 2) { // 오른쪽으로 밀때
        for(int i = 0; i < N; i++) {
            idx = N - 1;
            for(int j = N - 1; j >= 0; j--) {
                if(idx != N - 1 && !is_add && graph[i][idx + 1] == graph[i][j]) {
                    graph[i][idx + 1] *= 2;
                    graph[i][j] = 0;
                    is_add = true;
                }
                else if(graph[i][j]) {
                    if(idx == j) idx--;
                    else {
                        graph[i][idx] = graph[i][j];
                        graph[i][j] = 0;
                        idx--;
                    }
                    is_add = false;
                }
            }
        }
    }
    if(dir == 3) { // 위로
        for(int i = 0; i < N; i++) {
            idx = 0;
            for(int j = 0; j < N; j++) {
                if(idx != 0 && !is_add && graph[idx - 1][i] == graph[j][i]) {
                    graph[idx - 1][i] *= 2;
                    graph[j][i] = 0;
                    is_add = true;
                }
                else if(graph[j][i]) {
                    if(idx == j) idx++;
                    else {
                        graph[idx][i] = graph[j][i];
                        graph[j][i] = 0;
                        idx++;
                    }
                    is_add = false;
                }
            }
        }
    }
    if(dir == 4) { // 아래
        for(int i = 0; i < N; i++) {
            idx = N - 1;
            for(int j = N - 1; j >= 0; j--) {
                if(idx != N - 1 && !is_add && graph[idx + 1][i] == graph[j][i]) {
                    graph[idx + 1][i] *= 2;
                    graph[j][i] = 0;
                    is_add = true;
                }
                else if(graph[j][i]) {
                    if(idx == j) idx--;
                    else {
                        graph[idx][i] = graph[j][i];
                        graph[j][i] = 0;
                        idx--;
                    }
                    is_add = false;
                }
            }
        }
    }
}
int dfs(int (*graph)[21]) {
    int _max = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(_max < graph[i][j]) _max = graph[i][j];
        }
    }
    return _max;
}

int get_ans(int cnt, int (*graph)[21]) {
    int copy[21][21];
    int answer = 0;
    if(cnt == 5) {
        return answer = max(answer, dfs(graph));
    }

    for(int dir = 1; dir <= 4; dir++) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                copy[i][j] = graph[i][j];
            }
        }
        move(copy, dir);
        // cout << '\n';
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < N; j++) {
        //         cout << copy[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        answer = max(answer, get_ans(cnt + 1, copy));
    }
    return answer;
}

void pro() {
    cout << get_ans(0, graph);
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
    pro();
    return 0;
}