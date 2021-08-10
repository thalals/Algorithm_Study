import sys
input=sys.stdin.readline

S=input().rstrip()
# print(S)

result=''
ss=''
check=0
for i in S:
    if i=='<':
        result+=ss
        ss='<'
        check=1
    elif i=='>':
        result+=ss+">"
        ss=''
        check=0
    elif i==' ':
        result+=(ss+' ')
        ss=''
    else:
        if check==1:
            ss+=i
        else:
            ss=i+ss

if ss:
    result+=ss

print(result)