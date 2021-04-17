#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <cmath>
using namespace std;
struct BC {
    int x, y;
    int c, p;
};
int TC, MC, A;
int dx[] = {0, -1, 0, 1, 0};
int dy[] = {0, 0, 1, 0, -1};
vector<int> a(MC, 0);
vector<int> b(MC, 0);
vector<BC> bc;

int check(int ax, int ay, int bx, int by) {
    vector<int> pa(A, 0);
    vector<int> pb(A, 0);
    for(int i = 0; i < A; i++) {
        int dist_a = abs(ax - bc[i].y) + abs(ay - bc[i].x);
        int dist_b = abs(bx - bc[i].y) + abs(by - bc[i].x);
        if(dist_a <= bc[i].c) pa[i] = bc[i].p;
        if(dist_b <= bc[i].c) pb[i] = bc[i].p;
    }
    int sum = 0;
    for(int i = 0; i < A; i++) {
        for(int j = 0; j < A; j++) {
            if(i == j) {
                sum = max(sum, pa[i]);
                sum = max(sum, pb[i]);
            }
            else {
                sum = max(sum, pa[i] + pb[j]);
            }
        }
    }
    
    return sum;
}

void process(int testcase) {
    int a_x = 1, a_y = 1;
    int b_x = 10, b_y = 10;

    int answer = check(a_x, a_y, b_x, b_y);
    for(int i = 0; i < MC; i++) {
        a_x += dx[a[i]], a_y += dy[a[i]];
        b_x += dx[b[i]], b_y += dy[b[i]];
        answer += check(a_x, a_y, b_x, b_y);
    }
    cout << "#" << testcase << ' ' << answer << '\n';
}


void input() {
    cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        cin >> MC >> A; // MC: 총 이동시간 A: BC의 개수
        bc.clear();
        for(int i = 0; i < MC; i++) {
            a = vector<int> (MC, 0);
            b = vector<int> (MC, 0);
        }
        // 사람 정보입력
        for(int i = 0; i < MC; i++) cin >> a[i];
        for(int i = 0; i < MC; i++) cin >> b[i];
        // BC정보입력
        for(int i = 0; i < A; i++) {
            int x, y, c, p; cin >> x >> y >> c >> p;
            bc.push_back({x, y, c, p});
        }
        process(tc);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
    return 0;
}