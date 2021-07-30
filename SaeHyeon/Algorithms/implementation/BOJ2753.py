import sys
input=sys.stdin.readline

n=int(input())
flag=False
if (n%4)==0:
    if not (n%100)==0 or (n%400)==0:
        flag=True

if flag:
    print(1)
else:
    print(0)

