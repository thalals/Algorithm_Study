#include <iostream>
#include <vector>
using namespace std;

int N, M;
vector<int> uf;

int uf_find(int x) {
    return uf[x] == -1 ? x : uf[x] = uf_find(uf[x]);
}

void uf_union(int x, int y) {
    int X = uf_find(x), Y = uf_find(y);
    if(X == Y) return;
    uf[X] = Y;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;
    uf = vector<int>(N + 1, -1);

    for(int i = 0; i < M; i++) {
        int a, b, c; cin >> a >> b >> c;
        if(a == 0) {
            uf_union(b, c);
        } else {
            int B = uf_find(b), C = uf_find(c);
            if(B == C) cout << "YES\n";
            else cout << "NO\n";
        }
    }
}
