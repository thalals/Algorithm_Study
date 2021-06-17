#include <iostream>
using namespace std;
int n;
int t[20];
int p[20];
int ret;
void solution(int idx, int values) {
    if(idx == n) {
        ret = max(ret, values);
        return;
    }
    if(idx>n) return;
    
    // 오늘 상담할 경우
    solution(idx+t[idx], values+p[idx]);
    // 오늘 상담하지 않을 경우
    solution(idx+1, values);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>t[i]>>p[i];
    }

    solution(0,0);
    cout<<ret<<'\n';

    return 0;
}