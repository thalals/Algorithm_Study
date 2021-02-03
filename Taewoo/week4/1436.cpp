#include<bits/stdc++.h>
using namespace std;
int N;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    int i = 666;
    while(1) {
        if(to_string(i).find("666") != string::npos) N--;
        if(N == 0) break;
        i++;
    }

    cout << i;
}