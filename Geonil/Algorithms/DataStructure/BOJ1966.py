'''
problem : 프린터 큐 (BOJ 1966)
comment : 덱 이용- 우선순위 큐,순서 큐 두개 사용
'''
import sys
from collections import deque
In = sys.stdin.readline


class PrinterQueue:
    def __init__(self, n):
        self.queue = deque([i for i in range(n)])

    def get_order(self, priority, search):
        prio = deque(priority)
        order = 0

        while True:
            peek = prio[0]

            if peek == max(prio):
                out = self.queue.popleft()
                prio.popleft()
                order += 1
                if out == search:
                    return order
            else:
                self.queue.append(self.queue.popleft())
                prio.append(prio.popleft())


def main():
    case = int(In())
    answers = []

    for _ in range(case):
        n, search = map(int, In().split())
        priority = list(map(int, In().split()))
        printer = PrinterQueue(n)
        answer = printer.get_order(priority, search)
        answers.append(answer)

    print('\n'.join(map(str, answers)))


if __name__ == "__main__":
    main()
