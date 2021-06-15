#include <iostream>
#include <cmath>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int n, ans;
int map[11][11];

struct Node {
    int x, y, target, value;
    Node(int x, int y) : x(x), y(y) {};
    Node(int x, int y, int value) : x(x), y(y), value(value) {};
};

vector<Node> n_v;
vector<Node> s_v;

int distance_(int n_idx, int s_idx) {
    int x = abs(n_v[n_idx].x - s_v[s_idx].x);
    int y = abs(n_v[n_idx].y - s_v[s_idx].y);
    return x + y;
}

void dfs(int idx) {
    if(idx == n_v.size()) {
        int people_cnt = n_v.size();
        int time = 0;
        int exit_cnt = 0;

        queue<int> waiting[2];
        queue<int> stair[2];

        // 원하는 계단으로 가기 위한 거리 계산
        for(int i = 0; i < people_cnt; i++) {
            int dis = distance_(i, n_v[i].target);
            waiting[n_v[i].target].push(dis);
        }
        /*
            1. time++
            2. 계단에 있는 인원 내려가기
            3. 계단에 인원 추가하기
        */

       while(exit_cnt < people_cnt) {
           time++;

           // 계단 인원 내려가기
           for(int i = 0; i < 2; i++) {
               int size = stair[i].size();
               for(int j = 0; j < size; j++) {
                   int top = stair[i].front();
                   stair[i].pop();
                   top--;
                   if(top != 0) stair[i].push(top);
                   else exit_cnt++;
               }
           }

           // 계단에 인원 추가하기
           for(int i = 0; i < 2; i++) {
               int size = waiting[i].size();
               for(int j = 0; j < size; j++) {
                   int dis = waiting[i].front();
                   waiting[i].pop();
                   dis--;
                   if(dis <= 0) { // 도착 시
                        if(stair[i].size() < 3) { // 계단에 도착했지만 내려가는 인원이 FULL
                            stair[i].push(s_v[i].value);
                        }
                        else {
                            waiting[i].push(dis);
                        }
                   }
                   else {
                       waiting[i].push(dis);
                   }
               } 
           }
       }
       ans = ans < time + 1 ? ans : time + 1;
    }
    else {
        for(int i = 0; i < 2; i++) {
            n_v[idx].target = i;
            dfs(idx + 1);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int TC; cin >> TC;
    
    for(int tc = 1; tc <= TC; tc++) {
        memset(map, 0, sizeof(map));
        n_v.clear(); s_v.clear();

        cin >> n;
        ans = 2e9;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp; cin >> tmp;
                if(tmp == 1) n_v.push_back(Node(i, j));
                else if(tmp > 1) s_v.push_back(Node(i, j, tmp));
            }
        }
        dfs(0);
        cout << "#" << tc << " " << ans << '\n';
    }
}