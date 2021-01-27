#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    vector<int> list;
    for(int i = 0; i < 5; i++) list.push_back(i+1);
    for(auto i : list) cout << i << ' ';

    for(int i = 1; i <= 5; i++) {
        vector<int> candid;
        for(int j = 0; j < list.size() - i; j++) candid.push_back(0);
        for(int j = 0; j < i; j++) candid.push_back(1);
        cout << '\n';
        do{
            for(int idx = 0; idx < candid.size(); idx++) {
                if(candid[idx])
                    cout << list[idx] << ' ';
            }
            cout << '\n';
        } while(next_permutation(candid.begin(), candid.end()));
    }
    return 0;
}