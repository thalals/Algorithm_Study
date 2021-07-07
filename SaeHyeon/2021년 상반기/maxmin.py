import sys
input=sys.stdin.readline

s=list(map(int,input().split(' ')))
max_num,min_num=max(s),min(s)
answer=''+str(min_num)+' '+str(max_num)
print(answer)