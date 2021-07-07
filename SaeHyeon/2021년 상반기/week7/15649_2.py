#다른 방법으로 풀어보는 15649
#itertools 사용

import itertools
import sys
input=sys.stdin.readline

N,M=map(int,input().split())
li=list(itertools.permutations(range(1,N+1),M)) # tuple형식
for i in li:
    #print(type(i[0])) 
    print(i[0],i[1])