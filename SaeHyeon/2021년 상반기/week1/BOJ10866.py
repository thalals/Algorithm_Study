import sys
from collections import deque
input=sys.stdin.readline

dq=deque()

n=int(input())

for i in range(0,n):
    ins=input().split()
    if ins[0] == "push_front":
        dq.appendleft(ins[1])
    elif ins[0] == "push_back":
        dq.append(ins[1])
    elif ins[0] == "pop_front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.popleft())
    elif ins[0] == "pop_back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.pop())
    elif ins[0] == "size":
        print(len(dq))
    elif ins[0] == "empty":
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif ins[0] == "front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    elif ins[0] == "back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[len(dq)-1])

