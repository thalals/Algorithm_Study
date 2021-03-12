#include <bits/stdc++.h>
using namespace std;

struct node {
    int x;
    int dist;
    bool operator < (const node &node)const&{
        return dist > node.dist;
    }
};

int main() {
    vector<node> node;
    node.push_back({0, 2});
    node.push_back({1, 1});
    node.push_back({2, 4});
    node.push_back({3, 3});
    node.push_back({4, 7});

    sort(node.begin(), node.end());
    for(auto i: node) {
        cout << i.x << ' ' << i.dist << '\n';
    }
}