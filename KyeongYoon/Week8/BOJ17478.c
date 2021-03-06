#include <stdio.h>

int flag = 0;

void blank(int n) {
    if (flag == 0) {
        for (int i = 0; i < n; i++) {
            printf("____");
        }
    }
    else {
        for (int i = n; i > 0; i--) {
            printf("____");
        }
    }
}

void Qcycle(int n) {
    blank(n);   printf("\"재귀함수가 뭔가요?\"\n");
    blank(n);   printf("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
    blank(n);   printf("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
    blank(n);   printf("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
}

void Acycle(int n) {
    blank(n);   printf("라고 답변하였지.\n");
}

void recursion(int n) {
    if (n >= 1 && n <= 50) {
        for (int i = 0; i < n; i++) {
            Qcycle(i);
        }
        blank(n);   printf("\"재귀함수가 뭔가요?\"\n");
        blank(n);   printf("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        flag = 1;
        for (int i = n; i > 0; i--) {
            Acycle(i);
        }
        printf("라고 답변하였지.\n");
    }
}

int main(void) {
    int cnt;
    scanf("%d", &cnt);

    printf("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    recursion(cnt);
}