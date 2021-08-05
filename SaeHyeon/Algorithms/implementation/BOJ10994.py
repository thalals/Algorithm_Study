import sys
input=sys.stdin.readline

def star(n,idx):
    if n==1:
        draw[idx][idx]='*'
        return
    
    num=n*4-3

    for i in range(idx,idx+num):
        draw[idx][i]='*'
        draw[idx+num-1][i]='*'

        draw[i][idx]='*'
        draw[i][idx+num-1]='*'

    return star(n-1,idx+2)

N=int(input())
lenN=4*N-3
draw=[[' ']*lenN for _ in range(lenN)]

star(N,0)

for i in range(lenN):
    for j in range(lenN):
        print(draw[i][j],end='')
    print()