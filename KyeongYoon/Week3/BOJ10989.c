//카운팅정렬, 계수정렬
#include <stdio.h>

#define SIZE 10001

int arr[SIZE];

int main(void){
    int num;
    int cnt;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        scanf("%d", &num);
        arr[num]++;
    }

    for(int i = 0; i <= SIZE; i++){
        if(arr[i] == 0) continue;

        for(int j = 0; j < arr[i]; j++){
            printf("%d\n", i);
        }
    }
}

// 시간 초과, 메모리 초과
// #include <stdio.h>
// #include <string.h>

// #define SIZE 10001

// char arr[SIZE];
// int cnt_arr[SIZE];

// int main(void) {
//     int cnt;
//     scanf("%d", &cnt);

//     for (int i = 0; i < cnt; i++) {
//         scanf("%d", &arr[i]);
//     }

//     for (int i = 0; i < cnt; i++) {
//         cnt_arr[arr[i]] += 1;
//     }

//     for (int i = 0; i <= strlen(arr); i++) {
//         for (int j = 0; j < cnt_arr[i]; j++) {
//             printf("%d\n", i);
//         }
//     }
// }