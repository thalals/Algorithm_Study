import sys
input=sys.stdin.readline

left,right=map(str,input().split())
# 키보드 구성
keyboard=['qwertyuiop','asdfghjkl','zxcvbnm']
# 키보드 모음 위치
vowel='yuiophjklbnm'
string=input().rstrip()

lx,ly,rx,ry=0,0,0,0
for i in range(len(keyboard)):
    if left in keyboard[i]:
        lx=i
        ly=keyboard[i].index(left)

    if right in keyboard[i]:
        rx=i
        ry=keyboard[i].index(right)

time=0
for s in string:
    time+=1
    if s in vowel:
        for i in range(len(keyboard)):
            if s in keyboard[i]:
                nrx=i
                nry=keyboard[i].index(s)

                time+=abs(nrx-rx)+abs(nry-ry)
                rx=nrx
                ry=nry
                break
    else:
        for i in range(len(keyboard)):
            if s in keyboard[i]:
                nlx=i
                nly=keyboard[i].index(s)

                time+=abs(nlx-lx)+abs(nly-ly)
                lx=nlx
                ly=nly
                break

print(time)