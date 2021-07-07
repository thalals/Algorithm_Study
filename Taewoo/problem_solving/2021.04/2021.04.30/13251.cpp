#include <iostream>
#include <vector>
using namespace std;

double ret, p[51];
int n, m, k, a[51];
int main() {
    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> a[i];
        n += a[i];
    }

    cin >> k;
    for(int i = 0; i < m; i++) {
        if(a[i] < k) continue;
        p[i] = 1;
        for(int j = 0; j < k; j++) {
            p[i] *= (double)(a[i] - j) / (n - j);
        }
    }
    for(int i = 0; i < m; i++) ret += p[i];
    
    printf("%.9lf\n", ret);
    return 0;
}