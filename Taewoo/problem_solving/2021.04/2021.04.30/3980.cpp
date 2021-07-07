#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
int result;
int _map[11][11];
int visit[11];
void go(int cnt, int sum) {
    if(cnt == 11) {
        result = max(result, sum);
        return;
    }

    for(int i = 0; i < 11; i++) {
        if(_map[cnt][i] == 0) continue;
        if(visit[i] == 0) {
            visit[i] = 1;
            go(cnt + 1, sum + _map[cnt][i]);
            visit[i] = 0;
        }
    }
}

int main() {
    int T;
    cin >> T;
    for(int tc= 1; tc <= T; tc++) {

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                cin >> _map[i][j];
            }
        }
        memset(visit, 0, sizeof(visit));
        result = 0;
        go(0, 0);
        cout << result << "\n";
    }
}