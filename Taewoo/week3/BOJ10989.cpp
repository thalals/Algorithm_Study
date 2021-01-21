#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int cnt[10001];
    vector<int> v;

    memset(cnt, 0, sizeof(cnt));
    int n; cin>>n;
    
    for(int i = 0; i < n; i++) {
        int num; cin >> num;
        cnt[num]++;
    }

    for(int i = 1; i <= 10000; i++) {
        for(int j = 0; j < cnt[i]; j++)
            cout<<i<<'\n';
    }

}