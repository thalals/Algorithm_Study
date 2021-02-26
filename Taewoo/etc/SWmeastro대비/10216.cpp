#include<bits/stdc++.h>
using namespace std;

int camp[3000][3];
int uf[3000];

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
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, T; cin >> T;
    
    for(int i = 0; i < T; i++) {
        cin >> N;
        for(int j = 0; j < N; j++) {
            cin >> camp[j][0] >> camp[j][1] >> camp[j][2];
        }
        memset(uf, -1, sizeof(uf));
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                double dist = sqrt(pow(camp[i][0] - camp[j][0], 2) + pow(camp[i][1] - camp[j][1], 2));
                double r = camp[i][2] + camp[j][2];

                if(dist <= r) {
                    if(uf_union(i, j)) count++;
                }
            }
        }
        cout << N - count << '\n';
    }
}