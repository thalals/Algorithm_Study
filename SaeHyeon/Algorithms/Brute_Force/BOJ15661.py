#Problem : https://www.acmicpc.net/problem/15661
#Comment : 조합 부분은 다른 사람 코드에서 아이디어를 얻었음

import sys
from itertools import combinations
input=sys.stdin.readline

n=int(input())
score=[]
# 조합하려고 만들어 놓은 멤버 리스트
member_li=list(i for i in range(n))

for i in range(n):
    score.append(list(map(int,input().split())))
# 양 팀 간의 점수 차이 최솟값
ans=10**8


# 조합 만드려는 반복문 팀원이 최소 한명 이상이여야 하기 때문
for i in range(1,int((n/2)+1)):
    # 멤버 조합
    member=combinations(member_li,i)
    min_result=10**8
    #print(*member)

    for a in member:
        start=list(a)
        link=list(set(member_li)-set(start))
        #print(*start)
        #print(*link)
        start_all_sum=0
        link_all_sum=0

        # n-1을 한 이유는 상대팀에 적어도 한명 이상이기 때문에 
        # try,except를 한 이유는 한명인 팀 경우에는 0점이기 때문에
        for j in range(n-1):
            for k in range(n-1):
                try:
                    start_sum=score[start[j]][start[k]]
                except:
                    start_sum=0
                try:
                    link_sum=score[link[j]][link[k]]
                except:
                    link_sum=0
                # 팀원 능력치 합
                start_all_sum+=start_sum
                link_all_sum+=link_sum
        #스타트팀과 링크팀 능력치 차이
        result=abs(start_all_sum-link_all_sum)
        # 각 조합한 팀에서의 능력치 차이의 최솟값 구하기
        min_result=min(min_result,result)
    #구한 조합들 마다의 능력치 차이 구하기
    ans=min(ans,min_result)

print(ans)
        