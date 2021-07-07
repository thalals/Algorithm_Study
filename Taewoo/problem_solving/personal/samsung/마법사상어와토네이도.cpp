#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>
using namespace std;
struct Node {
    int x, y, dir;
};

int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
int wx[4][9] = {
    {-1, 1, -1, 1, -1, 1, -2, 2, 0}, // left
    {-1, -1, 0, 0, 1, 1, 0, 0, 2}, // down
    {-1, 1, -1, 1, -1, 1, -2, 2, 0}, // right
    {1, 1, 0, 0, -1, -1, 0, 0, -2} // up
};
int wy[4][9] = {
    {1, 1, 0, 0, -1, -1, 0, 0, -2}, // left
    {-1, 1, -1, 1, -1, 1, -2, 2, 0}, // down
    {-1, -1, 0, 0, 1, 1, 0, 0, 2}, // right
    {-1, 1, -1, 1, -1, 1, -2, 2, 0} // up
};

int percent[] = {1, 1, 7, 7, 10, 10, 2, 2, 5};

int N; int map[500][500];
int answer;
Node wind;

void input() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }
}

void spread() {
    int value = map[wind.x][wind.y];
    for(int i = 0; i < 9; i++) {
        int x = wind.x + wx[wind.dir][i];
        int y = wind.y + wy[wind.dir][i];

        int sand = (value * percent[i]) / 100;
        map[wind.x][wind.y] -= sand;

        if(x < 0 || y < 0 || x >= N || y >= N) {
            answer += sand;
            continue;
        }
        map[x][y] += sand;
    }

    // alpha Ã³¸®
    int x = wind.x + dx[wind.dir];
    int y = wind.y + dy[wind.dir];
    if(x < 0 || y < 0 || x >= N || y >= N) {
        answer += map[wind.x][wind.y];
        map[wind.x][wind.y] = 0;
        return;
    }
    else {
        map[x][y] += map[wind.x][wind.y];
        map[wind.x][wind.y] = 0;
    }
}

void move_wind(int length) {
    for(int i = 0; i < length; i++) {
        wind.x = wind.x + dx[wind.dir];
        wind.y = wind.y + dy[wind.dir];
        spread();
    }
}

void pro() {
    wind.x = N / 2; wind.y = N / 2; wind.dir = 0;

    int length = 1;
    for(int i = 1; i < N; i++) {
        for(int j = 1; j <= 2; j++) {
            move_wind(length);
            wind.dir = (wind.dir + 1) % 4;       
        }
        length++;
    }

    move_wind(length - 1);
    cout << answer << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    input();
    pro();
}