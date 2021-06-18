from collections import deque
import sys

input=sys.stdin.readline

def main():
    n=int(input())
    queue=deque()
    for i in range(n):
        s=input().split()
        if s[0] == 'push_front':
            queue.appendleft(int(s[1]))
        if s[0] == 'push_back':
            queue.append(int(s[1]))
        if s[0] == 'pop_front':
            if not queue:
                print(-1)
            else:
                print(queue.popleft())
        if s[0] == 'pop_back':
            if not queue:
                print(-1)
            else:
                print(queue.pop())
        if s[0] == 'size':
            print(len(queue))
        if s[0] == 'empty':
            if not queue:
                print(1)
            else:
                print(0)
        if s[0] == 'front':
            if not queue:
                print(-1)
            else:
                print(queue[0])
        if s[0] == 'back':
            if not queue:
                print(-1)
            else:
                print(queue[-1])


if __name__ == "__main__":
    main()