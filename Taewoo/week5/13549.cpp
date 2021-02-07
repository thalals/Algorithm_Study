// #include<bits/stdc++.h>
// using namespace std;
// queue<int> q;
// int visited[100004];
// int N, K;

// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
    
//     cin >> N >> K;

//     fill(visited, visited+100004, -1);
//     q.push(N);
//     visited[N] = 0;

//     while(!q.empty()) {
//         int x = q.front(); q.pop();
        
//         if(x == K) break;
        
//         if(x * 2 <= 100000 && (visited[x * 2] == -1 || visited[x * 2] > visited[x])) {
//             q.push(x * 2);
//             visited[x * 2] = visited[x];
//         }
//         if(x + 1 <= 100000 && (visited[x + 1] == -1 || visited[x + 1] > visited[x] + 1)) {
//             q.push(x + 1);
//             visited[x + 1] = visited[x] + 1;
//         }
//         if(x - 1 >= 0 && (visited[x - 1] == -1 || visited[x - 1] > visited[x] + 1)) {
//             q.push(x - 1);
//             visited[x - 1] = visited[x] + 1;
//         }
//     }
//     cout << visited[K];
// }


#include<bits/stdc++.h>
using namespace std;
queue<int> q;
int visited[100004];
int N, K;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> K;
    fill(visited, visited+100004, -1);
    q.push(N);
    visited[N] = 0;
    while(!q.empty()) {
        int x = q.front(); q.pop();
        
        if(x == K) break;
        if(x + 1 <= 100000) {
            if(visited[x + 1] == -1) {
                q.push(x + 1);
                visited[x + 1] = visited[x] + 1;
            }
            else {
                if(visited[x + 1] > visited[x] + 1) {
                    visited[x + 1] = visited[x] + 1;
                    q.push(x + 1);
                }
            }
        }
        if(x - 1 >= 0) {
            if(visited[x - 1] == -1) {
                q.push(x - 1);
                visited[x - 1] = visited[x] + 1;
            }
            else {
                if(visited[x - 1] > visited[x] + 1) {
                    visited[x - 1] = visited[x] + 1;
                    q.push(x - 1);  
                }
            }
        }
        if(x * 2 <= 100000) {
            if(visited[x * 2] == -1) {
                q.push(x * 2);
                visited[x * 2] = visited[x];
            }
            else {
                if(visited[x * 2] > visited[x]) {
                    visited[x * 2] = visited[x];
                    q.push(x * 2);
                }
            }
        }
    }
    cout << visited[K];
}