#include<bits/stdc++.h>
using namespace std;

string chess[51];
string white[8] = {
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"}
};
string black[8] = { 
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"},
    {"BWBWBWBW"},
    {"WBWBWBWB"}
};
const int INF = 1e9;
int N, M;
int answer = INF;
int check(int x, int y) {
    int whiteCount = 0, blackCount = 0;
    for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++){
            if(chess[x + i][y + j] != white[i][j]) whiteCount++;
            if(chess[x + i][y + j] != black[i][j]) blackCount++;
        }
    }
    return min(whiteCount, blackCount);
}

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for(int i = 0; i < N; i++)
        cin >> chess[i];


    int answer = 1e9;
    for(int i = 0; i + 7 < N; i++) {
        for(int j = 0; j + 7 < M; j++) {
            answer = min(answer, check(i, j));
        }
    }
    cout << answer;
    return 0;
}