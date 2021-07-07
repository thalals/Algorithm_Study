import sys
input=sys.stdin.readline

n,m=map(int,input().split())
mx,res,mxS=0,0,0
arr=[]
for i in range(n):
    arr.append(list(map(int,input().split())))

#print(arr)

pick=[0 for _ in range(3)]
mxT=[0 for _ in range(n)]
#print(pick)
#print(mxT)

def solve(idx,cnt):
    global res
    if cnt == 3:
        mx=0
        for i in range(n):
            mxS=0;
            for j in range(3):
                if mxS<arr[i][pick[j]]:
                    mxS=arr[i][pick[j]]
            mxT[i]=mxS
        for i in range(n):
            mx+=mxT[i]
        if mx>res:
            res=mx
        return

    for i in range(idx,m):
        pick[cnt]=i
        solve(idx+1,cnt+1)

solve(0,0)
print(res)