#include <iostream>
#include <vector>
using namespace std;

int tree[1000002][2];
void postorder(int idx) {
    if(idx == 0) return;
    postorder(tree[idx][0]);
    postorder(tree[idx][1]);
    cout << idx << "\n";
}

int main() {
    int root, s;
    scanf("%d ", &root);
    while(cin >> s) {
        int cur = root;
        while(true) {
            if (s < cur) {
                if(tree[cur][0] != 0) cur = tree[cur][0];
                else {
                    tree[cur][0] = s;
                    break;
                }
            }
            else {
                if(tree[cur][1] != 0) cur = tree[cur][1];
                else {
                    tree[cur][1] = s;
                    break;
                }
            }
        }
    }
    postorder(root);
    return 0;
}