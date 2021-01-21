#include<bits/stdc++.h>
using namespace std;
vector<int> graph[101];
int visited[101];
int answer;
int dfs(int start) {
    visited[start] = 1;

    for(int next: graph[start]) {
        if(!visited[next]) {
            answer+=dfs(next);
        }
    }
    return 1;
}

int main(){
    int a,b; cin >> a>> b;

    for(int i=0; i<b; i++) {
        int x, y; cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    dfs(1);
    cout<<answer<<'\n';
}