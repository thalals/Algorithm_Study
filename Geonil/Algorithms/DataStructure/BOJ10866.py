'''
problem : 데크 (BOJ 10866)
comment : deque 이용 구현
'''
import sys
from collections import deque
In = sys.stdin.readline


class Deque:
    def __init__(self):
        self.deq = deque()
        self.size = 0

    def is_empty(self):
        if self.size == 0:
            return True
        return False

    def get_size(self):
        return self.size

    def push_front(self, x):
        self.deq.appendleft(x)
        self.size += 1

    def push_back(self, x):
        self.deq.append(x)
        self.size += 1

    def pop_front(self):
        if self.is_empty():
            return -1
        self.size -= 1
        return self.deq.popleft()

    def pop_back(self):
        if self.is_empty():
            return -1
        self.size -= 1
        return self.deq.pop()

    def print_front(self):
        if self.is_empty():
            print(-1)
            return
        print(self.deq[0])

    def print_back(self):
        if self.is_empty():
            print(-1)
            return
        print(self.deq[self.size-1])


def main():
    n = int(In())
    deq = Deque()

    for _ in range(n):
        cmd = list(In().rstrip().split())
        string = cmd[0]

        if string == 'push_front':
            deq.push_front(int(cmd[1]))
        elif string == 'push_back':
            deq.push_back(int(cmd[1]))
        elif string == 'pop_front':
            print(deq.pop_front())
        elif string == 'pop_back':
            print(deq.pop_back())
        elif string == 'size':
            print(deq.get_size())
        elif string == 'empty':
            if deq.is_empty():
                print(1)
            else:
                print(0)
        elif string == 'front':
            deq.print_front()
        elif string == 'back':
            deq.print_back()


if __name__ == "__main__":
    main()
