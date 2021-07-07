#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
bool C[10];
struct info {int y, x;};
struct _b {
    int color, time;
};
vector<pair<int, int> > can;
vector<int> Gr, Re;
_b B[50][50];
int A[50][50];
int ans, row, col, green, red;

int bfs() {
    return 1;
}

void go(int idx, int cnt, int g, int r) {

    if(cnt > can.size()) return;
    if(g > green) return;
    if(r > red) return;
    if(g == green && r == red)  {
        ans = max(ans, bfs());
        cout << '\n' << '\n';
        cout << "GREEN" << '\n';
        for(auto i : Gr) {
            cout << can[i].first << ' ' << can[i].second << '\n';
        }
        cout << '\n';
        cout << "RED" << '\n';
        for(auto i : Re) {
            cout << can[i].first << ' ' << can[i].second << '\n';
        }
        cout << '\n';
        return;
    }

    for(int i = idx; i < can.size(); i++) {
        if(C[i]) continue;
        C[i] = true;
        Gr.push_back(i);
        go(i, cnt + 1, g + 1, r);
        Gr.pop_back();
        Re.push_back(i);
        go(i, cnt + 1, g, r + 1);
        Re.pop_back();
        C[i] = false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> row >> col >> green >> red;

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            cin >> A[i][j];
            if(A[i][j] == 2) can.push_back(make_pair(i, j));
        }
    }

    go(0, 0, 0, 0);
}