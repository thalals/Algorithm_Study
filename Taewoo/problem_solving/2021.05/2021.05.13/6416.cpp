#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int edge = 0;
    set <int> node;
    int idx = 1;
    while(true) {
        int a, b;
        cin >> a >> b;
        if (a == -1 && b == -1) break;
        if (a == 0 && b == 0) {
            if(edge + 1 == node.size() || edge == 0)
                cout << "Case " << idx << " is a tree.\n";
            else
                cout << "Case " << idx << " is not a tree.\n";
            idx++;
            edge = 0;
            node.clear();
        }
        else {
            node.insert(a); node.insert(b);
            edge++;
        }
    }
}