# 시간 초과
# 2차 덱으로 해보기
import sys

input=sys.stdin.readline

a,b=map(int,input().split())

arr=[i+1 for i in range(0,a)]
index=1
stack=[]
arr.reverse()

while True:
    if len(arr) == 0:
        break
    else:
        if index == b:
            stack.append(arr.pop())
            index=1
        else:
            arr.insert(0,arr.pop())
            index+=1

print("<%s>" %(", ".join(map(str,stack))))
