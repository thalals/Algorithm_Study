import sys
input=sys.stdin.readline
li=[]
k,n=map(int,input().split())
for i in range(k):
    li.append(int(input()))
#print(li)
#랜선의 길이를 찾는 것이니깐 끝의 값을 최댓값으로
start,end=1,max(li)

while start<=end:
    mid=(start+end)//2
    cnt=0
    for i in li:
        cnt+=i//mid
    if cnt >= n:
        start=mid+1
    else:
        end=mid-1
print(end)