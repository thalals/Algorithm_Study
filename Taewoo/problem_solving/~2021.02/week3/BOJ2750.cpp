#include<bits/stdc++.h>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int N; cin >> N;
    vector<int> v;
    
    for(int i = 0; i < N; i++){
        int a; cin >> a;
        v.push_back(a);
    }

    for(int i = 0; i < v.size(); i++) {
        int min_index = i;
        for(int j = i+1; j < v.size(); j++) {
            if(v[min_index] > v[j]) min_index = j;
        }
        swap(v[min_index], v[i]);
    }
    for(int i : v) cout << i << '\n';
}