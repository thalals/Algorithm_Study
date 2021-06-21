#Problem : https://www.acmicpc.net/problem/1966
#Comment : 시간 초과

from collections import deque
import sys

input=sys.stdin.readline

def main():
    test=int(input())
    queue=deque()
    for i in range(test):
        n,m=map(int,input().split())
        li=list(map(int,input().split()))
        if m == 0:
            queue.append(li[0])
        else:
            queue.append(li[m-1])
    
    #print(queue[0],queue[1])
    while queue:
        if len(queue) == 1:
            print(queue.popleft())
        else:
            if queue[0] > queue[1]:
                queue.append(queue.popleft())
            elif queue[0] < queue[1]:
                print(queue.popleft())
                
if __name__ == "__main__":
    main()