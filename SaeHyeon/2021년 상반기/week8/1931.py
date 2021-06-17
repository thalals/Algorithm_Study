import sys
input=sys.stdin.readline

#n개의 회의
#회의에 대해 시작시간과 끝나는 시간이 주어짐
#안겹치게 회의실을 사용하는 회의의 최대 개수

n=int(input())
time=[]
result=[]
for i in range(n):
    a,b=map(int,input().split())
    time.append([a,b])


# 정렬 조건을 x[0],x[1]순으로 하니깐 틀림
time.sort(key=lambda x:(x[1],x[0]))
#print(time)
cnt=0
value=0

# 이렇게 하면 반복문 2개요소 한번에 인덱스 가능
# for i,j in time:
#     print(i,j)

for i,j in time:
    if i>=value:
        cnt+=1
        value=j
print(cnt)
