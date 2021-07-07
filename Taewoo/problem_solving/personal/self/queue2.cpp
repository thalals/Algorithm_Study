#include<bits/stdc++.h>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    queue<int> q;
    int N; cin >> N;
    
    for(int i = 0; i < N; i++) {
        string input; cin >> input;
        if(input == "push") {
            int num; cin >> num;
            q.push(num);
        }
        else if (input == "pop") {
            if(!q.empty()) {
                cout << q.front()<< '\n';
                q.pop();
            }
            else cout << -1 << '\n';
        }
        else if(input == "size") cout << q.size() << '\n';
        else if(input == "empty") {
            if(!q.empty()) cout << q.empty() << '\n';
            else cout << q.empty() << '\n';
        }
        else if(input == "front") {
            if(!q.empty()) cout << q.front()<< '\n';
            else cout << -1 << '\n';
        }
        else {
            if(!q.empty()) cout << q.back()<< '\n';
            else cout << -1 << '\n';
        }
    }
}