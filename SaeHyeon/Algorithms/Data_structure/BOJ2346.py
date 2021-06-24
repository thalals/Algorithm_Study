from collections import deque
import sys
input=sys.stdin.readline

def main():
    n=int(input())
    li=list(map(int,input().split()))
    queue=deque(li)
    result=[]

    a=queue.popleft()
    while queue:
        result.append(li.index(a)+1)
        if a > 0:
            for i in range(a-1):
                queue.append(queue.popleft())
            a=queue.popleft()
        elif a<0:
            for i in range(a):
                queue.append(queue.popleft())
            a=queue.popleft()
    print(result)

if __name__ == "__main__":
    main()