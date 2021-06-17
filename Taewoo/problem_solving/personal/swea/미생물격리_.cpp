#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

struct Bug {
    int x, y, num, dir;
    bool status;
    Bug(int x, int y, int num, int dir, bool status): x(x), y(y), num(num), dir(dir), status(status) {}
};

int answer;
vector<int> map[100][100];
vector<Bug> bug;
int n, m, k;
int change_dir[] = {0, 2, 1, 4, 3};
int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, -1, 1};
void input() {
    cin >> n >> m >> k;
    for(int i = 0; i < k; i++) {
        int x, y, n, d; cin >> x >> y >> n >> d;
        bug.push_back(Bug(x, y, n, d, true));
        map[x][y].push_back(i);
    }
}

void move_bug() {
    for(int i = 0; i < bug.size(); i++) {
        if(bug[i].status == false) continue;
        map[bug[i].x][bug[i].y].clear();
    }

    for(int i = 0; i < bug.size(); i++) {
        if(bug[i].status == false) continue;
        bug[i].x += dx[bug[i].dir];
        bug[i].y += dy[bug[i].dir];
        map[bug[i].x][bug[i].y].push_back(i);
    }
}

void sum_kill() {
    for(int i = 0; i < bug.size(); i++) {
        if(bug[i].status == false) continue;

        int x = bug[i].x;
        int y = bug[i].y;
        int dir = bug[i].dir;

        if(x == 0 || y == 0 || x == n - 1 || y == n - 1) {
            bug[i].num = bug[i].num / 2;
            bug[i].dir = change_dir[bug[i].dir];
        }

        if(bug[i].num == 0) {
            bug[i].status = false;
        }
    }

    for(int i = 0; i < bug.size(); i++) {
        if(bug[i].status == false) continue;

        int x = bug[i].x, y = bug[i].y;

        if(map[x][y].size() > 1) {
            int sum = 0;
            int big_num = 0;
            int select_dir = 0;
            int select_idx = 0;

            for(int j = 0; j < map[x][y].size(); j++) {
                sum = sum + bug[map[x][y][j]].num; // 미생물 합치기
                if(bug[map[x][y][j]].num > big_num) {
                    big_num = bug[map[x][y][j]].num;
                    select_dir = bug[map[x][y][j]].dir;
                    select_idx = map[x][y][j];
                }
                bug[map[x][y][j]].status = false;
            }
            bug[select_idx].num = sum;
            bug[select_idx].dir = select_dir;
            bug[select_idx].status = true;
            map[x][y].clear();
            map[x][y].push_back(select_idx);
        }
    }
}

int calc() {
    int sum = 0;
    for(int i = 0; i < bug.size(); i++) {
        if(bug[i].status == false) continue;
        sum += bug[i].num;
    }
    return sum;
}

void pro() {
    // 시간 만큼 돌리기
    for(int i = 0; i < m; i++) {
        move_bug();
        sum_kill();
    }
    answer = calc();
}

void process() {
    int TC; cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        answer = 0;
        bug.clear();
        for(int i = 0; i < 100; i++) for(int j = 0; j < 100; j++) map[i][j].clear();
        input();
        pro();
        cout << "#" << tc << " " << answer << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    process();
}