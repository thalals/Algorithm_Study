## 맨 처음 풀이

# n = int(input())

# result = []


# for i in range(n):
#     command = input().split()
    

    
#     if command[0] == "push":
#         result.append(command[1])
    
#     elif command[0] == "pop":
#         if len(result) == 0:
#             print(-1)
#         else:
#             print(result.pop())

#     elif command[0] == "size":
#         print(len(result))

#     elif command[0] == "empty":
#         if len(result) == 0:
#             print("1")
#         else:
#             print("0")
#     elif command[0] == "top":
#         if len(result) == 0:
#             print("-1")
#         else:
#             print(result[-1])

## 시간 초과로 인해서 sys.stdin.readline() 사용
## 어느 글에서 본 입출력 속도 비교
## sys.stdin.readline > raw_input() > input()

import sys
n = int(sys.stdin.readline())

result = []

for i in range(n):
    command = sys.stdin.readline().split()

    
    if command[0] == "push":
        result.append(command[1])
    
    elif command[0] == "pop":
        if len(result) == 0:
            print(-1)
        else:
            print(result.pop())

    elif command[0] == "size":
        print(len(result))

    elif command[0] == "empty":
        if len(result) == 0:
            print("1")
        else:
            print("0")
    elif command[0] == "top":
        if len(result) == 0:
            print("-1")
        else:
            print(result[-1])



