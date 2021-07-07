#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int change_dir[6][4] = {
    {0, 0, 0, 0},
    {1, 3, 0, 2},
    {1, 2, 3, 0},
    {2, 0, 3, 1},
    {3, 0, 1, 2},
    {1, 0, 3, 2}
};

int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int graph[100][100];
int TC, N;
int start_x, start_y;
vector<pair<int, int>> holl[11];



int dfs(int x, int y, int dir) {
    int score = 0;
    while(true) {
        x += dx[dir], y += dy[dir];
        // º®¿¡ ºÎµúÈú °æ¿ì
        if(x < 0 || y < 0 || x == N || y == N) {
            if(dir == 0) dir = 1;
            else if(dir == 1) dir = 0;
            else if(dir == 2) dir = 3;
            else if(dir == 3) dir = 2;
            score++;
            continue;
        }

        // ºí·Ï¿¡ ºÎµúÈù °æ¿ì
        if(graph[x][y] >= 1 && graph[x][y] <= 5) {
            dir = change_dir[graph[x][y]][dir];
            score++;
            continue;
        }

        // ¿úÈ¦ÀÏ °æ¿ì
        if(graph[x][y] > 5) {
            int num = graph[x][y];
            if(x == holl[num][0].first && y == holl[num][0].second) {
                x = holl[num][1].first;
                y = holl[num][1].second;
            }
            else {
                x = holl[num][0].first;
                y = holl[num][0].second;
            }
            continue;
        }

        // ºí·¢È¦ÀÎ °æ¿ì
        if(graph[x][y] == -1) 
            break;
        if(x == start_x && y == start_y) 
            break;
    }
    return score;
}

void process(int testcase) {
    int answer = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(graph[i][j] != 0) continue;

            start_x = i, start_y = j;
            for(int dir = 0; dir < 4; dir++) {
                answer = max(answer, dfs(i, j, dir));
            }
        }
    }
    cout << "#" << testcase << " " << answer << '\n';
}

void input() {
    cin >> TC;
    for(int tc = 1; tc <= TC; tc++) {
        cin >> N;

        memset(graph, 0, sizeof(graph));
        for(int i = 6; i < 11; i++) holl[i].clear();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                cin >> graph[i][j];
                if(graph[i][j] > 5) {
                    holl[graph[i][j]].push_back({i, j});
                }       
            }
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