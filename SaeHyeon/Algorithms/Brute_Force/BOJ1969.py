#Problem : https://www.acmicpc.net/problem/1969
#Comment : 결과는 맞게 나왔는데 틀림, 나중에 다시 풀어보기

import sys
input=sys.stdin.readline

n,m=map(int,input().split())
arr=[]
for _ in range(n): 
    s=input().strip()
    arr.append(s)

#print(arr)
result=''
cnt=0
for i in range(m):
    dna=[0,0,0,0]
    for j in range(n):
        if arr[j][i]== 'A':
            dna[0]+=1
        elif arr[j][i] =='T':
            dna[1]+=1
        elif arr[j][i] =='G':
            dna[2]+=1
        elif arr[j][i] =='C':
            dna[3]+=1

    a=dna.index(max(dna))

    if a==0:
        result+='A'
    if a==1:
        result+='T'
    if a==2:
        result+='G'
    if a==3:
        result+='C'

for i in range(m):
    for j in range(n):
        if arr[j][i]!=result[i]:
            cnt+=1
print(result)
print(cnt)
