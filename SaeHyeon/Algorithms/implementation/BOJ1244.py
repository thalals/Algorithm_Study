import sys
input=sys.stdin.readline

n=int(input())
switch=list(map(int,input().split()))
student=int(input())

def man(idx):
    cnt=0
    for i in range(0,n):
        cnt+=1
        if cnt==3:
            cnt=0
            if switch[i]==0:
                switch[i]=1
            else:
                switch[i]=0

def women(idx):
    position=idx-1
    if switch[position]==1:
        switch[position]=0
    elif switch[position]==0:
        switch[position]=1
    for i in range(1,n):
        left_p=position-i
        right_p=position+i
        if 0<=left_p and right_p <=n:
            if switch[left_p] == switch[right_p]:
                if switch[left_p]==0:
                    switch[left_p]=1
                    switch[right_p]=1
                elif switch[left_p]==1:
                    switch[left_p]=0
                    switch[right_p]=0
            else:
                break
for _ in range(student):
    a,b=map(int,input().split())
    if a==1:
        man(b)
    if a==2:
        women(b)

print(*switch)

