#Problem : https://www.acmicpc.net/problem/2800
#Comment : 풀줄 몰라서 다른사람 풀이 보고 이해함

from itertools import combinations
# 문자열을 리스트로 저장
problem=[*input().strip()]
p, idx_brs=[],[]

for i,v in enumerate(problem):
    if v=='(':
        #문자열에서 ( 를 제거
        problem[i]=''
        # (가  있었던 index를 저장
        p+=[i]
    if v==')':
        #문자열에서 )를 제거
        problem[i]=''
        #p에 저장되어있던 ( 의 위치와 맞는 )의 위치를 idx_brs에 저장
        idx_brs+=[[p.pop(),i]]    
#print(problem)
#print(idx_brs)

#이거는 중복을 피하니깐 사용한듯
out=set()

#combinations함수를 이용해서 순열을 만든다.
for i in range(len(idx_brs)):
    for j in combinations(idx_brs,i):
        #print(j)
        P=problem[:]
        #print(P)
        for v,w in j:
            P[v]='('
            P[w]=')'
        out.add(''.join(P))
    #print(out)

for i in sorted(out):
    print(i)