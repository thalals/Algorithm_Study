#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
int tmp;
int visited[10];
vector<int> v;
vector<vector<int>> d;
vector<int> temp;
void go(int here){
  if(temp.size()==m){
      d.push_back(temp);
      return;
  }
  for(int i=here+1; i<v.size(); i++){
    if(visited[i]) continue;
    temp.push_back(v[i]);
    visited[i]=1;
    go(here);
    visited[i]=0;
    temp.pop_back();
  }
}
int main() {
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>tmp;
    v.push_back(tmp);
  }
  go(-1);
  sort(d.begin(),d.end());
  d.erase(unique(d.begin(), d.end()),d.end());
  for(auto &v : d){
    for(auto &t : v){
      cout<<t<<' ';
    }cout<<'\n';
  }
}