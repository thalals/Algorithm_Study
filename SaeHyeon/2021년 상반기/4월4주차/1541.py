import sys
input=sys.stdin.readline

line=input().split('-')
#print(line)
num=[]

for i in line:
    value=0
    plus=i.split('+')
    for j in plus:
        #print(j)
        value+=int(j)
    num.append(value)

n=num[0]
for i in range(1,len(num)):
    n-=num[i]

print(n)       