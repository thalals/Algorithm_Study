#include <iostream>
#include <algorithm>
#include <string>
typedef long long int ll;
using namespace std;

#define NM 25

int a[25][25], n, m;
void input() {
    cin >> n >> m;
}

int ans = 0;
void rec_func(int x, int y) {
    if (x == n + 1) {
        ans++;
        return;
    }
    if (y == m + 1) {
        rec_func(x + 1, 1);
        return;
    }
    if (!(a[x][y - 1] == 1 && a[x - 1][y] == 1 && a[x - 1][y - 1] == 1)) {
        a[x][y] = 1;
        rec_func(x, y + 1);
        a[x][y] = 0;
    }
    rec_func(x, y + 1);
}

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    input();
    rec_func(1, 1);
    cout << ans;
    return 0;
}