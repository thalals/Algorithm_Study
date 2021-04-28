#include<bits/stdc++.h>
using namespace std;

void quickSort(vector<int> &v, int start, int end) {
    if(start>=end) return;
    int pivot = start;
    int left = start + 1;
    int right = end;

    while(left<=right) {
        while(left<=end && v[left] <= v[pivot]) left++;
        while(right>start && v[right] >= v[pivot]) right--;
        if(left > right) swap(v[right], v[pivot]);
        else swap(v[left], v[right]);
    }
    
    quickSort(v, start, right - 1);
    quickSort(v, right + 1, end);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int N; cin >> N;
    vector<int> v;
    
    for(int i = 0; i < N; i++){
        int a; cin >> a;
        v.push_back(a);
    }

    quickSort(v, 0, v.size()-1);
    for(int i : v) cout << i << '\n';
}