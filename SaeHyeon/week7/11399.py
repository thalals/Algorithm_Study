import sys
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))

def li_sort(li):
    li2=[]
    num=len(li)
    for i in range(num):
        li2.append(li.pop(li.index(min(li))))
    return li2

def solve(li,cnt):
    li2=[]
    sum_num=0
    for i in range(len(li)):
        sum_num+=li[i]
        li2.append(sum_num)
    cnt=sum(li2)
    return cnt
li2=li_sort(li)
print(solve(li2,0))
