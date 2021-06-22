import sys
input=sys.stdin.readline

n,t=map(int,input().split())
time,width,num=map(int,input().split())

bus=[[]*n]
#print(bus)
for i in range(n):
    for j in range(num):
        bus[i].append(time+(width*j))

#print(bus)
if n < 1:
    print(-1)
else:
    for i in range(n):    
        for j in bus[i]:
            if j > t:
                print(j-t)
                break
        
