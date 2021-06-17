
import sys
input=sys.stdin.readline

n=int(input())
cnt=1
array=[]
stack=[]
result=True
for i in range(0,n):
    m=int(input())
    while cnt <= m:
        array.append(cnt)
        cnt+=1
        stack.append("+")
    if array[-1] == m:
        array.pop()
        stack.append("-")
    else:
        result=False

if result == False:
    print("NO")
else:
    for i in range(0,len(stack)):
        print(stack[i])
