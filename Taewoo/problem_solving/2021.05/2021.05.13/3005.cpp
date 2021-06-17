#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int R, C;
vector<string> arr;
bool visit[21][21][2];
int dx[2] = {0, 1};
int dy[2] = {1, 0};
vector<string> answer;
void isOk(int x, int y, int type) {
    visit[x][y][type] = true;

    string res = "";
    res += arr[x][y];
    int nx = x + dx[type];
    int ny = y + dy[type];
    while(nx < arr.size() && ny < arr[0].size() && arr[nx][ny] != '#') {
        visit[nx][ny][type] = true;
        res += arr[nx][ny];
        nx += dx[type];
        ny += dy[type];
    }
    if(res.size() >= 2)
        answer.push_back(res);
}

int main() {
    cin >> R >> C;
    for(int i = 0; i < R; i++) {
        string str;
        cin >> str;
        arr.push_back(str);
    }    

    string res = "";
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            if(arr[i][j] == '#') continue;
            for(int k = 0; k < 2; k++)
                if(!visit[i][j][k]) isOk(i, j, k);
        }
    }
    sort(answer.begin(), answer.end());
    cout << answer[0];
    return 0;
}