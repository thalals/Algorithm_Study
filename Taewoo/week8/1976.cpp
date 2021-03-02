#include<bits/stdc++.h>
using namespace std;

int N, M; // 도시의 수 N, 도시에 속한 도시들의 수 M;
int uf[201];
int uf_find(int x) {
    return uf[x] == -1 ? x : uf[x] = uf_find(uf[x]);
}

bool uf_union(int x, int y) {
    int X = uf_find(x);
    int Y = uf_find(y);
    if(X == Y) return false;
    uf[X] = Y;
    return true;
}

int main() {
    cin >> N >> M;
    memset(uf, -1, sizeof(uf));
    
    int value;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            cin >> value;
            if(value) uf_union(i, j);
        }
    }
    int temp;
    bool isOk = true;
    cin >> temp;
    int root = uf_find(temp);
    for(int i = 1; i < M; i++) {
        cin >> temp;
        if(root != uf_find(temp)) isOk = 0;
    }
    if(isOk) cout << "YES";
    else cout << "NO";
}