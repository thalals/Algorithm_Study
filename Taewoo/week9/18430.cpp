/*
Problem: 무기 공학 (18430)
https://www.acmicpc.net/problem/18430
나무 재료의 형태와 각 칸의 강도가 주어졌을 때, 
길동이가 만들 수 있는 부메랑들의 강도 합의 최댓값을 출력하는 프로그램을 작성하시오. 
Comment: 문제가 너무 길다...
*/

#include <bits/stdc++.h>
using namespace std;

int n, m, answer;
int graph[6][6];
bool visited[6][6];

int power(int dir, int x, int y) {
    if(dir == 0) return 2 * graph[x][y] + graph[x + 1][y] + graph[x][y - 1];
    if(dir == 1) return 2 * graph[x][y] + graph[x - 1][y] + graph[x][y - 1];
    if(dir == 2) return 2 * graph[x][y] + graph[x - 1][y] + graph[x][y + 1];
    if(dir == 3) return 2 * graph[x][y] + graph[x + 1][y] + graph[x][y + 1];
    return 0;
}

void dfs(int x, int y, int values) {
    if(y == m) { 
        // 다음 행 확인
        y = 0;
        x++;
    }

    if(x == n) {
        answer = max(answer, values);
        return;
    }

    if(!visited[x][y]) {
        // ㄱ
        if(x + 1 < n && y - 1 >= 0 && !visited[x + 1][y] && !visited[x][y - 1]) {
            visited[x][y] = true;
            visited[x + 1][y] = true;
            visited[x][y - 1] = true;
            int sum = values + power(0, x, y);
            dfs(x, y + 1, sum);
            visited[x][y] = false;
            visited[x + 1][y] = false;
            visited[x][y - 1] = false;
        }
        // ⎦
        if(x - 1 >= 0 && y - 1 >= 0 && !visited[x - 1][y] && !visited[x][y - 1]) {
            visited[x][y] = true;
            visited[x - 1][y] = true;
            visited[x][y - 1] = true;
            int sum = values + power(1, x, y);
            dfs(x, y + 1, sum);
            visited[x][y] = false;
            visited[x - 1][y] = false;
            visited[x][y - 1] = false;
        }
        // ㄴ
        if(x - 1 >= 0 && y + 1 < m && !visited[x - 1][y] && !visited[x][y + 1]) {
            visited[x][y] = true;
            visited[x - 1][y] = true;
            visited[x][y + 1] = true;
            int sum = values + power(2, x, y);
            dfs(x, y + 1, sum);
            visited[x][y] = false;
            visited[x - 1][y] = false;
            visited[x][y + 1] = false;
        }
        // ⎡
        if(x + 1 < n && y + 1 < m && !visited[x + 1][y] && !visited[x][y + 1]) {
            visited[x][y] = true;
            visited[x + 1][y] = true;
            visited[x][y + 1] = true;
            int sum = values + power(3, x, y);
            dfs(x, y + 1, sum);
            visited[x][y] = false;
            visited[x + 1][y] = false;
            visited[x][y + 1] = false;
        }
    }
    dfs(x, y + 1, values);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> graph[i][j];
        }
    }
    dfs(0, 0, 0);
    cout << answer;
}