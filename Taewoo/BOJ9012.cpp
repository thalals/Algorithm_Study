#include<iostream>
using namespace std;

int main() {
    int T; cin>>T;
    
    while(T--) {
        string s; cin>>s;
        int cnt = 0;
        for(int i=0; i<s.size(); i++) {
            if(s[i]=='(') cnt++;
            else {
                cnt--;
                if(cnt<0) {
                    cout<<"NO"<<'\n';
                    break;
                }
            }
        }
        if(cnt==0) cout<<"YES"<<'\n';
        else if(cnt>0) cout<<"NO"<<'\n';
    }
    return 0;
}