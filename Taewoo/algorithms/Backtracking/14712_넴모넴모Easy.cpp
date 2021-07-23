#include <iostream>
using namespace std;

int a[25][25], N, M, answer;
void go(int x, int y) {
    if (x == N + 1) {
        answer++;
        return;
    }
    if (y == M + 1) {
        go(x + 1, 1);
        return;
    }
    if (!(a[x][y-1] == 1 && a[x-1][y] == 1 && a[x-1][y-1] == 1)) {
        a[x][y] = 1;
        go(x, y + 1);
        a[x][y] = 0;
    }
    go(x, y + 1);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    go(1, 1);
    cout << answer;
    return 0;
}