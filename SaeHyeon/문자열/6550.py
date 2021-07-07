import sys
input=sys.stdin.readline

for i in range(4):
    s,t=input().split()
    if s=='':
        break
    if (s in t) == True:
        print('Yes')
    else:
        print('No')