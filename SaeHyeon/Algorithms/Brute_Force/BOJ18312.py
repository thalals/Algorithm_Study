import sys
input=sys.stdin.readline
cnt=0

h=''
m=''
s=''
n,k=map(int,input().split())
for i in range(n+1):
    if i<10:
        h='0'+str(i)
    else:
        h=str(i)
    for j in range(60):
        if j<10:
            m='0'+str(j)
        else:
            m=str(j)
        for z in range(60):
            if z<10:
                s='0'+str(z)
            else:
                s=str(z)
            if str(k) in h+m+s:
                cnt+=1
print(cnt)