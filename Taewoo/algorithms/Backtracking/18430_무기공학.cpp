#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, answer;
int graph[5][5], used[5][5];
void input() {
    cin >> N >> M;
    for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) cin >> graph[i][j];
}

int calc(int type, int x, int y) {
    if(type == 0) return 2 * graph[x][y] + graph[x][y-1] + graph[x+1][y];
    else if(type == 1) return 2 * graph[x][y] + graph[x-1][y] + graph[x][y-1];
    else if(type == 2) return 2 * graph[x][y] + graph[x-1][y] + graph[x][y+1];
    else return 2 * graph[x][y] + graph[x+1][y] + graph[x][y+1];
}

void find_weapon(int x, int y, int sum) {
    if(x == N) {
        answer = max(answer, sum);
        return;
    }

    if(y == M) {
        x++;
        y = 0;
        find_weapon(x+1, 0, sum);
        return;
    }

    if(!used[x][y]) {
        // ¤¡
        if(y - 1 >= 0 && x + 1 < N && !used[x+1][y] && !used[x][y-1]) {
            used[x+1][y] = 1;
            used[x][y-1] = 1;
            used[x][y] = 1;
            find_weapon(x, y + 1, sum + calc(0, x, y));
            used[x][y] = 0;
            used[x+1][y] = 0;
            used[x][y-1] = 0;
            
        }
        // ?
        if(y - 1 >= 0 && x - 1 >= 0 && !used[x][y-1] && !used[x-1][y]) {
            used[x-1][y] = 1;
            used[x][y-1] = 1;
            used[x][y] = 1;
            find_weapon(x, y + 1, sum + calc(1, x, y));
            used[x][y] = 0;
            used[x-1][y] = 0;
            used[x][y-1] = 0;
        }

        // ¤¤
        if(y + 1 < M && x - 1 >= 0 && !used[x][y+1] && !used[x-1][y]) {
            used[x-1][y] = 1;
            used[x][y+1] = 1;
            used[x][y] = 1;
            find_weapon(x, y + 1, sum + calc(2, x, y));
            used[x][y] = 0;
            used[x-1][y] = 0;
            used[x][y+1] = 0;
        }
        // ?
        if(y + 1 < M && x + 1 < N && !used[x+1][y] && !used[x][y+1]) {
            used[x+1][y] = 1;
            used[x][y+1] = 1;
            used[x][y] = 1;
            find_weapon(x, y + 1, sum + calc(3, x, y));
            used[x][y] = 0;
            used[x+1][y] = 0;
            used[x][y+1] = 0;
        }
    }
    find_weapon(x, y + 1, sum);
}

void pro() {
    find_weapon(0, 0, 0);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}