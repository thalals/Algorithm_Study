#include <iostream>
using namespace std;

int tree[200001][2];
int answer;
void find(int root, long long k) {
    if(tree[root][0] == -1 && tree[root][1] == -1) {
        answer = root;
        return;
    }
    else if(tree[root][0] == -1) {
        find(tree[root][1], k);
    }
    else if(tree[root][1] == -1) {
        find(tree[root][0], k);
    }
    else if(tree[root][0] != -1 && tree[root][1] != -1){
        if(k % 2 == 1) {
            find(tree[root][0], k / 2 + 1);
        }
        else find(tree[root][1], k / 2);
    }
    return;
}


int main() {
    int n; long long k;
    cin >> n;

    for(int i = 1; i <= n; i++)
        cin >> tree[i][0] >> tree[i][1];

    
    cin >> k;
    
    find(1, k);
    cout << answer;
}