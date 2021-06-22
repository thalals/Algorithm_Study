import sys
from collections import deque

n = int(sys.stdin.readline())

result = deque([])

for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == "push":
        result.append(command[1])

    elif command[0] == "pop":
        if not result:
            print(-1)
        else:
            print(result.popleft())
    
    elif command[0] == "size":
        print(len(result))

    elif command[0] == "empty":
        if not result: # 스택에선 오른쪽처럼 쓰지만 deque에선 왼쪽처럼 작성함. if len(result) == 0:
            print(1)
        else:
            print(0)
    
    elif command[0] == "front":
        if not result:
            print(-1)
        else:
            print(result[0])
    elif command[0] == "back":
        if not result:
            print(-1)
        else:
            print(result[-1])
         
        
    