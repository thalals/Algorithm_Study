#include<bits/stdc++.h>
using namespace std;
bool compare(const pair<int, string> &a, const pair<int, string> &b) {
    return a.first < b.first;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    vector<pair<int, string>> person;

    for(int i = 0; i < n; i++) {
        int age; string name;
        cin >> age >> name;
        person.push_back({age, name});
    }
    stable_sort(person.begin(), person.end(), compare);

    for(auto i : person) cout << i.first << ' ' << i.second << '\n';
}