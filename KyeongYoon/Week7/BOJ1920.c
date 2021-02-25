#include <stdio.h>
#define SIZE 100000

int A[SIZE];
int key[SIZE];

void bubbleSort(int arr[]);
int BSearch(int arr[], int, int);

int main(void) {
    int num1, num2;

    scanf("%d", &num1);
    for (int i = 0; i < num1; i++) {
        int ins;
        scanf("%d", &ins);
        A[i] = ins;
    }

    scanf("%d", &num2);
    for (int i = 0; i < num2; i++) {
        int ins;
        scanf("%d", &ins);
        key[i] = ins;
    }

    bubbleSort(A);

    for (int i = 0; i < num2; i++) {
        printf("%d\n", BSearch(A, key[i], num1));
    }
}

void bubbleSort(int arr[]) {
    for (int i = 0; i < sizeof(arr); i++) {
        for (int j = 0; j < sizeof(arr) - i; j++) {
            if (arr[i] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int BSearch(int arr[], int target, int size) {
    int low = 0;
    int high = size - 1;
    int mid = 0;

    while(low <= high) {
        mid = (low + high) / 2;

        if (arr[mid] == target) return 1;
        if (arr[low] == target) return 1;
        if (arr[high] == target) return 1;
        else if (arr[mid] > target) high = mid - 1;
        else low = mid + 1;
    }
    return 0;
}