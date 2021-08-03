# 문제 : 백준 12933
# 내용 : 다시 한번
import sys
input=sys.stdin.readline

ori='quack'
#ori=["q",'u','a','c','k']
s=list(input().rstrip())

cs=[]
boo=False
for i in range(len(s)):
    # if cs[0]==ori:
    #     break
    if i ==0:
        if not s[i]=='q':
            print(-1)
            break
        cs.append('q')
        continue

    if s[i]=='q':
        for j in range(len(cs)):
            if not cs[j][-1]=='k':
                cs.append('q')
                break
            if cs[j][-1]=='k':
                cs[j]+=s[i]
                break

    if s[i]=='u':
        for j in range(len(cs)):
            if cs[j][-1]=='q':
                cs[j]+=s[i]
                break


    if s[i]=='a':
        for j in range(len(cs)):
            if cs[j][-1]=='u':
                cs[j]+=s[i]
                break

    if s[i]=='c':
        for j in range(len(cs)):
            if cs[j][-1]=='a':
                cs[j]+=s[i]
                break

    if s[i]=='k':
        for j in range(len(cs)):
            if cs[j][-1]=='c':
                cs[j]+=s[i]
                break

            

    
print(cs)    
print(len(cs))
