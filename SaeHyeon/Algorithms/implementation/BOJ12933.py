# 문제 : 백준 12933
# 내용 : 다시 한번
import sys
input=sys.stdin.readline

s=list(input().rstrip())

cs=[]
check=False
for i in range(len(s)):
    if i==0:
        if s[i]=='q':
            cs.append('q')
            continue
        else:
            check=False
            break

    if s[i]=='u':
        check=False
        for j in range(len(cs)):
            if cs[j][-1]=='q':
                cs[j]+=s[i]
                check=True
                break
        if check==False:
            break


    if s[i]=='a':
        check=False
        for j in range(len(cs)):
            if cs[j][-1]=='u':
                cs[j]+=s[i]
                check=True
                break
        if check==False:
            break
    
    if s[i]=='c':
        check=False
        for j in range(len(cs)):
            if cs[j][-1]=='a':
                cs[j]+=s[i]
                check=True
                break
        if check==False:
            break
    
    if s[i]=='k':
        check=False
        for j in range(len(cs)):
            if cs[j][-1]=='c':
                cs[j]+=s[i]
                check=True
                break
        if check==False:
            break

    if s[i]=='q':
        b=False
        for j in range(len(cs)):
            if cs[j][-1]=='k':
                cs[j]+=s[i]
                b=True
                break
        if not b:
            cs.append('q')

ori='quack'
if len(s)%5==0:
    if check==False:
        print(-1)
    else:
        for i in range(len(cs)):
            cs[i]=cs[i].replace(ori,"")
        if len(cs[i])==0:
            print(len(cs))
        else:
            print(-1)
else:
    print(-1)
