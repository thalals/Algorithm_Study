import sys
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))
compa=[-1 for i in range(0,n)]
f=[0 for i in range(0,n+1)]
stack=[]
print(n)
print(li)
print(compa)
print(f)
for i in range(1,n+1):
    if li.count(i) != 0:
        f[i]=li.count(i)

print(f)

for i in range(1,n+1):
    while li[i] 
    

while max and li[max[-1]] < li[i]:
        print(max[-1],i)
        print(li[max[-1]], li[i])
        result[max.pop()]=li[i]