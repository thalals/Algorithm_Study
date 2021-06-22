import sys

n=int(sys.stdin.readline())
li=[]
for i in range(n):
    li.append(sys.stdin.readline().split())

li.sort(key=lambda x:int(x[0])) #int안할 시 틀림

for i in range(len(li)):
    print(li[i][0],li[i][1])