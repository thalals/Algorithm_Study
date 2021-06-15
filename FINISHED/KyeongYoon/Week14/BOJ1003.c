// BOJ1003 피보나치 함수 - DP(Dynamic Programming - 동적 계획법)
#include <stdio.h>
#define SIZE 40

int fibo[SIZE] = { 1,0 };

int main(void) {
    int T, N;
    scanf("%d", &T);

    for (int i = 2; i <= 41; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    for (int i = 0; i < T; i++) {
        scanf("%d", &N);
        printf("%d %d \n", fibo[N], fibo[N+1]);
    }
    return 0;
}

// 시간초과
/*
#include <stdio.h>
#define SIZE 40 

int fibonacci(int n);
int fibo[SIZE];

int cnt0 = 0, cnt1 = 0;

int main(void) {
    int T, N;
    scanf("%d", &T);

    for (int i = 0; i < T; i++) {
        cnt0 = 0;
        cnt1 = 0;
        scanf("%d", &N);
        fibonacci(N);
        printf("%d %d \n", cnt0, cnt1);
    }
    return 0;
}

int fibonacci(int n) {
    if(n <= 1){
        if(n == 0) cnt0++;
        else if(n == 1) cnt1++;

        fibo[n] = n;
        return n;
    }
    else{
        fibo[n] = fibonacci(n-1) + fibonacci(n-2);
        return fibo[n];
    }
}
*/