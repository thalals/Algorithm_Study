#include <stdio.h>
#include <string.h>

char* step_1(char);
char* new_id[1001];

int main(void){
    scanf("%s", *new_id);

    new_id[1001] = step_1(*new_id); 
    printf("%s", step_1(*new_id));
}

char* step_1(char arr){
    return strlwr(arr);
}

char step_2(char arr[]){
    for(int i = 0; i < strlen(arr); i++){
        if(33 <= arr[i] <= 44 || arr[i] == 47 || 58 <= arr[i] <= 64 || 91 <= arr[i] <= 94 || arr[i] == 96 || 123 <= arr[i] <= 126) arr[i] = NULL; // -_. ~!@#$%^&*()=+[{]}:?,<>/
    }
    for(int i = 0; i < strlen(arr); i++){
        if(arr[i] != NULL && arr[i+1] == NULL) arr[i+1] = arr[i+2];
    }
    return arr;
}