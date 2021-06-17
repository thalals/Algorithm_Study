#include<iostream>
#include<vector>
using namespace std;
vector<pair<int, int>> person;
int answer[51];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    fill(answer, answer+51, 1);
    int N; cin >> N;
    for(int i = 0; i < N; i++) {
        int x, y; cin >> x >> y;
        person.push_back({x, y});
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(person[i].first > person[j].first && person[i].second > person[j].second){
                answer[j]++;
            }
        }
    }

    for(int i = 0; i < N; i++) cout << answer[i] << ' ';
}