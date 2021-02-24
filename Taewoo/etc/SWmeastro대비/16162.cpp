#include<bits/stdc++.h>
using namespace std;

int main() {
    int N, A, D;
    cin >> N >> A >> D;
    int check = A;
    int count = 0;

    for(int i = 0; i < N; i++) {
        int rhythm; cin >> rhythm;
        if(check == rhythm) {
            count++;
            check = rhythm + D;
        }
    }
    cout << count;
}