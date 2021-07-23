#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m, t;
int visited[10];
vector<int> v;
vector<int> tmp;
void go(){
  if(tmp.size()==m){
    for(auto &ref: tmp){
      cout<<ref<<' ';
    }cout<<'\n';
    return;
  }
  for(int i=0; i<v.size(); i++){
    tmp.push_back(v[i]);
    go();
    tmp.pop_back();
  }
}

int main(){
  cin>>n>>m;

  for(int i=0; i<n; i++){
    cin>>t;
    v.push_back(t);
  }
  sort(v.begin(), v.end());
  go();
}