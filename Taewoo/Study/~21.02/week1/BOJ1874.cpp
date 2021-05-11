#include<iostream>
#include<stack>
#include<vector>
using namespace std;
int a[100004];
stack<int> stk;
vector<char> vec;

int main() {
    int num;
    int idx = 0;
    int n; cin>>n;

    for(int i=0; i<n; i++)
        cin>>a[i];

    for(int i=1; i<=n; i++) {
        stk.push(i);
        vec.push_back('+');
        while(stk.size() && stk.top() == a[idx]) {
            idx++;
            stk.pop();
            vec.push_back('-');
        }
    }
    if(stk.size()) cout<<"NO"<<'\n';
    else {
        for(char i : vec)
            cout<<i<<'\n';
    }
    return 0;
}