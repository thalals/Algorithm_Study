#include <iostream>
#include <vector>
using namespace std;
vector<vector<int> > d;
vector<int> temp;
vector<int> vec;
int n, m;
int visit[10];

void find() {
    if(temp.size() == m) {
        for(auto i: temp) cout << i << " ";
        cout << "\n";
        // d.push_back(temp);
        return;
    }

    for(int i = 0; i < vec.size(); i++) {
        if(visit[i]) continue;
        temp.push_back(vec[i]);
        visit[i] = 1;
        find();
        visit[i] = 0;
        temp.pop_back();
    }
}

int main() {
    cin >> n >> m;

    for(int i = 0; i < n; i++) {
        int x; cin >> x;
        vec.push_back(x);
    }

    find();
    sort(d.begin(), d.end());
    d.erase(unique(d.begin(), d.end()), d.end());
    // for(auto v : d) {
    //     for(int i : v) {
    //         cout << i << " ";
    //     }
    //     cout << "\n";
    // }
    return 0;
}