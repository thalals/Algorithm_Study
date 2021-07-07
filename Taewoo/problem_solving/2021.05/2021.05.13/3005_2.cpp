#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int R, C;
vector<string> arr;
bool visit[21][21];
int dx[2] = {0, 1};
int dy[2] = {1, 0};
vector<string> answer;
void isOk(int x, int y, int row) {
    visit[x][y] = true;

    string res = "";
    res += arr[x][y];
    int nx = x + dx[row];
    int ny = y + dy[row];
    while(nx < arr.size() && ny < arr[0].size() && arr[nx][ny] != '#') {
        visit[nx][ny] = true;
        res += arr[nx][ny];
        nx += dx[row];
        ny += dy[row];
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
            if(!visit[i][j]) isOk(i, j, 0);
        }
    }

    for(int i = 0; i < R; i++) for(int j = 0; j < C; j++) visit[i][j] = false;
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            if(arr[i][j] == '#') continue;
            if(!visit[i][j]) isOk(i, j, 1);
        }
    }

    sort(answer.begin(), answer.end());
    cout << answer[0];
    return 0;
}