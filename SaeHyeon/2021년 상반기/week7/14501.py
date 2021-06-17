import sys
input=sys.stdin.readline

N=int(input())
li=[]
for i in range(N):
    a,b=map(int,input().split())
    li.append([a,b])

# 얻을 수 있는 비용만 리스트로 따로 저장
result=list(map(lambda x:x[1],li))

for i in range(N):
    # 해당날짜+ 일하는데 걸리는 날짜가 퇴사까지 남은 날보다 크면 최대 비용을 0으로
    if i+li[i][0] > N:
        result[i]=0
        continue
    #버는 비용
    prize=result[i]
    #시작 날부터 일하고 난 후 날짜후에 비용을 기존에 있는 비용과 비교후 최대값을 결과 리스트에 저장해줌
    for j in range(i+li[i][0],N):
        if prize+li[j][1] > result[j]:
            result[j]=prize+li[j][1]
            

print(max(result))