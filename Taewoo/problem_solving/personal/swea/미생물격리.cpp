#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <cmath>
using namespace std;

struct Bug {
    int x; int y; int cnt; int dir; // x, y, 미생물 수, 방향
};
// 방향 상하좌우(1,2,3,4)
int map[101][101];
int change_dir[] = {0, 2, 1, 4, 3};
int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, -1, 1};
pair<int, int> max_bug[101][101]; // cnt dir

int main() {
    int TC; cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        int n, m, k; // 셀의 개수 n 격리시간 M 미생물 군집의 개수 k
        cin >> n >> m >> k;
        memset(max_bug, 0, sizeof(max_bug));
        vector<Bug> bug;
        for(int i = 0; i < k; i++) {
            int a, b, c, d; cin >> a >> b >> c >> d;
            bug.push_back({a, b, c, d});
        }
        
        while(m--) {
            memset(map, -1, sizeof(map));

            // Move Bug
            for(int i = 0; i < k; i++) {
                if(bug[i].cnt == 0) continue;

                bug[i].x += dx[bug[i].dir];
                bug[i].y += dy[bug[i].dir];
                
                // 가장 자리 경우
                if(bug[i].x == 0 || bug[i].x == n - 1 || bug[i].y == 0 || bug[i].y == n - 1) {
                    bug[i].cnt /= 2;
                    bug[i].dir = change_dir[bug[i].dir];
                    map[bug[i].x][bug[i].y] = i;
                }

                // 이미 다른 군집이 있는 경우
                else if(map[bug[i].x][bug[i].y] != -1) {
                    int pre_bug_idx = map[bug[i].x][bug[i].y];
                    if(max_bug[bug[i].x][bug[i].y].first > bug[i].cnt) {
                        bug[pre_bug_idx].cnt += bug[i].cnt;
                        bug[i].cnt = 0;
                    }
                    else {
                        max_bug[bug[i].x][bug[i].y] = {bug[i].cnt, bug[i].dir};
                        bug[i].cnt += bug[pre_bug_idx].cnt;
                        bug[pre_bug_idx].cnt = 0;
                        map[bug[i].x][bug[i].y] = i;
                    }
                }

                else {
                    map[bug[i].x][bug[i].y] = i;
                    max_bug[bug[i].x][bug[i].y] = {bug[i].cnt, bug[i].dir};
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < k; i++) {
            answer += bug[i].cnt;
        }
        printf("#%d %d\n", tc, answer);
    }
}