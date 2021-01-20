#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define MAX 100001
#define true 1
#define false 0

int front = -1;
int rear = -1;
int queue[MAX];

int IsEmpty(void);
void push(int value);
int pop();
int size();
int print_front();
int print_back();

int main(void) {
    int cnt;
    scanf("%d", &cnt);

    for (int i = 0; i < cnt; i++) {
        char func[7];
        scanf("%s", func);

        if (!strcmp(func, "push")) {
            int val;
            scanf("%d", &val);
            push(val);
        }
        else if (!strcmp(func, "pop")) printf("%d\n", pop());
        else if (!strcmp(func, "size")) printf("%d\n", size());
        else if (!strcmp(func, "empty")) printf("%d\n", IsEmpty());
        else if (!strcmp(func, "front")) printf("%d\n", print_front());
        else if (!strcmp(func, "back")) printf("%d\n", print_back());
    }
    return 0;
}

int IsEmpty(void) {
    if (front == rear) return true;
    else return false;
}

void push(int val) {
    queue[++rear] = val;
}

int pop() {
    if (IsEmpty()) return -1;
    else return queue[++front];
}

int size() {
    return rear + 1;
}

int print_front() {
    if (IsEmpty()) return -1;
    return queue[0];
}

int print_back() {
    if (IsEmpty()) return -1;
    else return queue[rear];
}