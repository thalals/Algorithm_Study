def find_arr(arr):
    global result
    

t=int(input())

for c in range(t):
    arr=[]
    result=float('inf')
    for _ in range(3):
        s=list(input().split()))
        for i in range(3):
            if s[i]=='T':
                s[i]=1
            else:
                s[i]=0
        arr.append(s)

    cnt=0
    find_arr(arr)