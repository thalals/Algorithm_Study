#include <iostream>
#include <vector>
using namespace std;

int N;
int P, Q;
int number[9];
int candid[9];
vector<char> oper;
char operation[9];
bool visited[9];
bool oper_visited[9];
void input() {
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> number[i];
    cin >> P >> Q;
    for(int i = 0; i < P; i++) oper.push_back('x');
    for(int i = 0; i < Q; i++) oper.push_back('+');
}

void dfs2(int idx) {
    // P , Q
    if(idx == N - 1) {
        for(int i = 0; i < N - 1; i++) {
            cout << operation[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i = 0; i < P + Q; i++) {
        if(oper_visited[i]) continue;
        oper_visited[i] = true;
        operation[idx] = oper[i];
        dfs2(idx + 1);
        oper_visited[i] = false;
        operation[idx] = ' ';
    }
}

void dfs(int idx) {
    if(idx == N) {
        for(int i = 0; i < N; i++)
            cout << candid[i] << " ";
        cout << "\n";
        dfs2(0);
        return;
    }

    for(int i = 0; i < N; i++) {
        if(visited[i]) continue;
        visited[i] = true;
        candid[idx] = number[i];
        dfs(idx + 1);
        visited[i] = false;
        candid[idx] = 0;
    }
}

void pro() {
    dfs(0);
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
}