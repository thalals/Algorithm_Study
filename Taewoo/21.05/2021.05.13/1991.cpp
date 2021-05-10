#include <iostream>
#include <vector>
using namespace std;

string result[3];
int tree[27][2];
int N;
// https://velog.io/@embeddedjune/VSCode-WSL2%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-CC-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%B9%8C%EB%93%9CGDB-%EB%94%94%EB%B2%84%EA%B9%85-%EB%B0%A9%EB%B2%95-%EB%A9%94%EB%AA%A8
void preorder(int idx) {
    result[0] += char(idx + 'A' - 1);
    if(tree[idx][0]) preorder(tree[idx][0]);
    if(tree[idx][1]) preorder(tree[idx][1]);
}
void inorder(int idx) {
    if(tree[idx][0]) inorder(tree[idx][0]);
    result[1] += char(idx + 'A' - 1);
    if(tree[idx][1]) inorder(tree[idx][1]);
}
void postorder(int idx) {
    if(tree[idx][0]) postorder(tree[idx][0]);
    if(tree[idx][1]) postorder(tree[idx][1]);
    result[2] += char(idx + 'A' - 1);
}

void input() {
    cin >> N;
    for(int i = 0; i < N; i++) {
        char parent, left, right;
        cin >> parent >> left >> right;
        if(left != '.') tree[parent - 'A' + 1][0] = left - 'A' + 1;
        if(right != '.') tree[parent - 'A' + 1][1] = right - 'A' + 1;
    }
}

void pro() {
    preorder(1);
    inorder(1);
    postorder(1);
    for(int i = 0; i < 3; i++) cout << result[i] << "\n";
}

int main() {
    input();
    pro();
}