'''
problem : 큐2 (BOJ 18258)
comment : deque 이용 구현
'''
import sys
from collections import deque
In = sys.stdin.readline


class Queue:
    def __init__(self):
        self.queue = deque()
        self.size = 0

    def is_empty(self):
        if self.size == 0:
            return True
        return False

    def push(self, x):
        self.queue.append(x)
        self.size += 1

    def pop(self):
        if self.is_empty():
            return -1
        self.size -= 1
        return self.queue.popleft()

    def front(self):
        if self.is_empty():
            return -1
        return self.queue[0]

    def back(self):
        if self.is_empty():
            return -1
        return self.queue[self.size-1]


def main():
    n = int(In())
    queue = Queue()

    for _ in range(n):
        cmd = list(In().rstrip().split())
        string = cmd[0]
        if string == 'push':
            queue.push(int(cmd[1]))
        elif string == 'pop':
            print(queue.pop())
        elif string == 'size':
            print(queue.size)
        elif string == 'empty':
            if queue.is_empty():
                print(1)
            else:
                print(0)
        elif string == 'front':
            print(queue.front())
        elif string == 'back':
            print(queue.back())


if __name__ == "__main__":
    main()
