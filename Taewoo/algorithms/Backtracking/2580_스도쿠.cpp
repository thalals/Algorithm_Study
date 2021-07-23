#include<bits/stdc++.h>
using namespace std;

int graph[9][9];
int rows[9][10];
int cols[9][10];
int box[9][10];
void input() {
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cin >> graph[i][j];
            if(graph[i][j]) {
                rows[i][graph[i][j]] = 1;
                cols[j][graph[i][j]] = 1;
                box[(i/3)*3 + (j/3)][graph[i][j]] = 1;
            }
        }
    }
}

void go(int cnt) {
    if(cnt == 81) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                cout << graph[i][j] << ' ';
            }
            cout << '\n';
        }
    }

    int x = cnt / 9;
    int y = cnt % 9;

    if(graph[x][y] == 0) {
        for(int i = 1; i <= 9; i++) {
            if(!rows[x][i] && !cols[y][i] && !box[(x/3)*3 + (y/3)][i]) {
                rows[x][i] = 1;
                cols[y][i] = 1;
                box[(x/3)*3 + (y/3)][i] = 1;
                graph[x][y] = i;
                go(cnt + 1);
                rows[x][i] = 0;
                cols[y][i] = 0;
                box[(x/3)*3 + (y/3)][i] = 0;
                graph[x][y] = 0;
            }
        }
    }
    else go(cnt + 1);    
}

void pro() {
    go(0);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}