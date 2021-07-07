/*
Problem : https://www.acmicpc.net/problem/1874
Comment : 숫자 1부터 넣으면 배열과 크기 비교하면서 +, - 출력하기
*/
#include <bits/stdc++.h>
#define MAX 100000
using namespace std;

int N;
int arr[MAX];
void input() {
    cin >> N;
    for(int i = 0; i < N; i++) cin >> arr[i];
}

stack<int> stk;
void pro() {
    int idx = 0;
    for(int i = 1; i <= N; i++) {
        stk.push(i);
        cout << '+' << '\n';
        while(!stk.empty() && stk.top() == arr[idx]) {
            idx++;
            stk.pop();
            cout << '-' << '\n';
        }
    }
    if(stk.size()) cout << "NO" << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}
// 1 2 5 6 