#Problem : https://www.acmicpc.net/problem/2164
#Comment : 해결


import sys
from collections import deque
input=sys.stdin.readline

def shuffle(q,n):
    while q:
        if len(q) == 1:
            return q.popleft()
        q.popleft()
        q.append(q.popleft())

def main():
    n=int(input())
    queue=deque()
    for i in range(n):
        queue.append(i+1)
    print(shuffle(queue,n))

if __name__ == "__main__":
    main()