#include <iostream>
#include <set>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        multiset<int> ms;
        int tc; cin >> tc;
        for(int j = 0; j < tc; j++) {
            char c; int num;
            cin >> c >> num;
            if(c == 'I') ms.insert(num);
            else if(ms.empty()) continue;
            else if(num == -1) ms.erase(ms.begin());
            else if(num == 1) ms.erase(--ms.end());
        }
        if(ms.empty()) cout << "EMPTY" << '\n';
        else cout << *(--ms.end()) << ' ' << *(ms.begin()) << '\n';
    }
    return 0;
}